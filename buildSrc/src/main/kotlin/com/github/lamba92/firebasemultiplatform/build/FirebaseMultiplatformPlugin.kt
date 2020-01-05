package com.github.lamba92.firebasemultiplatform.build

import com.jfrog.bintray.gradle.BintrayPlugin
import com.jfrog.bintray.gradle.tasks.BintrayUploadTask
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.internal.artifact.FileBasedMavenArtifact
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.tasks.Sync
import org.gradle.internal.os.OperatingSystem
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper

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
        }

        android {

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            compileSdkVersion(29)
            buildToolsVersion("29.0.2")

            defaultConfig {
                minSdkVersion(14)
            }

            alignSourcesForKotlinMultiplatformPlugin(target)
        }

        kotlin {

            android {
                publishLibraryVariants("release")
                mavenPublication {
                    if (!artifactId.startsWith(rootProject.name))
                        artifactId = "${rootProject.name}-$artifactId"
                }
            }

            val mainTarget = iosArm64()
            val otherTargets = listOf(iosX64())

            configure(otherTargets) {
                task<Sync>("copySourcesInto${name.capitalize()}Main") {
                    group = "native source copy"
                    from(mainTarget.compilations["main"].defaultSourceSet.kotlin.sourceDirectories)
                    into(compilations["main"].defaultSourceSet.kotlin.sourceDirectories.first())
                }.also { compilations["main"].compileKotlinTask.dependsOn(it) }
            }
        }

        publishing.publications.withType<MavenPublication> {
            if (!artifactId.startsWith(rootProject.name))
                artifactId = "${rootProject.name}-$artifactId"
        }


        val bintrayUsername = searchPropertyOrNull("bintrayUsername")
            ?: searchPropertyOrNull("BINTRAY_USERNAME")
        val bintrayApiKey = searchPropertyOrNull("bintrayApiKey")
            ?: searchPropertyOrNull("BINTRAY_API_KEY")

        if (bintrayApiKey != null && bintrayUsername != null)
            bintray {
                user = bintrayUsername
                key = bintrayApiKey
                pkg {
                    version {
                        name = project.version.toString()
                    }
                    repo = "com.github.lamba92"
                    name = "firebase-multiplatform"
                    setLicenses("Apache-2.0")
                    vcsUrl = "https://github.com/lamba92/FirebaseMultiplatform"
                    issueTrackerUrl = "https://github.com/lamba92/FirebaseMultiplatform/issues"
                }
                publish = true

                setPublications {
                    if (OperatingSystem.current().isMacOsX)
                        listOf("iosArm64", "iosX64")
                    else
                        listOf("androidRelease", "kotlinMultiplatform", "metadata")
                }
                log("Set up publications names: ${publications.joinToString()}")
            }
        else
            log("Publishing credentials not found.")

        tasks.withType<BintrayUploadTask> {
            doFirst {
                publishing.publications.withType<MavenPublication> {
                    buildDir.resolve("publications/$name/module.json").let {
                        if (it.exists())
                            artifact(object : FileBasedMavenArtifact(it) {
                                override fun getDefaultExtension() = "module"
                            })
                    }
                }
            }
        }

    }

}
