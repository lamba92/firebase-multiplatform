package com.github.lamba92.firebasemultiplatform.build

import com.github.lamba92.gradle.utils.*
import com.jfrog.bintray.gradle.BintrayPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.tasks.Sync
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinPackageJsonTask
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import java.io.File

@Suppress("unused")
class FirebaseMultiplatformPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {

        apply<KotlinMultiplatformPluginWrapper>()
        apply<MavenPublishPlugin>()
        apply<BintrayPlugin>()
        apply<AndroidLibraryPlugin>()

        repositories {
            mavenCentral()
            google()
            jcenter()
            maven("https://kotlin.bintray.com/kotlinx")
            maven("https://dl.bintray.com/lamba92/com.github.lamba92")
            maven("https://dl.bintray.com/kotlin/kotlin-eap")
        }

        androidLibrary {

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            compileSdkVersion(29)
            buildToolsVersion("30-rc4")

            defaultConfig {
                minSdkVersion(14)
            }

            alignSourcesForKotlinMultiplatformPlugin(target)
        }

        val fName = project.name
            .capitalize()
            .prefixIfNot("Firebase")

        val generateDefFileTask =
            task<GenerateDefForFramework>("generate${fName}DefFile") {
                dependsOn(extractFirebaseIosZip)
                val rootFrameworkDir = File(extractFirebaseIosZip.destinationDir, "$fName.framework")
                framework = rootFrameworkDir
                libraryPaths = listOf(rootFrameworkDir)
                staticLibraries = listOf(File(rootFrameworkDir, fName))
                packageName = "com.google.firebase"
                output = file("$buildDir/interop/def/$fName.def")
                buildStatic = true
            }


        kotlinMultiplatform {

            android {
                publishLibraryVariants("release")
            }

            js {
                nodejs()
                compilations.all {
                    kotlinOptions {
//                            freeCompilerArgs += listOf("-Xir-produce-js", "-Xgenerate-dts")
                        moduleKind = "commonjs"
                    }
                }
                mavenPublication {
                    val jsPackageJson: KotlinPackageJsonTask by tasks
                    artifact(jsPackageJson.packageJson)
                }
            }

            val mainTarget = iosArm64()
            val otherTargets = listOf(iosX64())

            val copyMainTargetSources by tasks.creating(Sync::class) {
                group = "native source copy"
                from(mainTarget.compilations["main"].defaultSourceSet.kotlin.sourceDirectories)
                into("$buildDir/generated/nativeCopy")
            }

            otherTargets.map { it.compilations["main"] }
                .applyEach {
                    defaultSourceSet.kotlin.srcDir(copyMainTargetSources.destinationDir)
                    compileKotlinTask.dependsOn(copyMainTargetSources)
                    kotlinOptions.freeCompilerArgs += listOf(
                        "-module-name",
                        "com.github.lamba92.firebase-multiplatform-${project.name}-cinterop"
                    )
                    cinterops {
                        create(project.name) {
                            defFile = generateDefFileTask.output
                            includeDirs(file("${generateDefFileTask.framework.absolutePath}/Headers"))
                            compilerOpts("-F${generateDefFileTask.framework.parentFile.absolutePath}")
                        }
                    }
                    enableEndorsedLibs = true
                }

            tasks.withType<CInteropProcess> {
                dependsOn(generateDefFileTask)
            }
        }

        afterEvaluate {
            publishing.publications.withType<MavenPublication> {
                if (!artifactId.startsWith(rootProject.name))
                    artifactId = "${rootProject.name}-$artifactId"
            }
            prepareForPublication()
        }

    }

}
