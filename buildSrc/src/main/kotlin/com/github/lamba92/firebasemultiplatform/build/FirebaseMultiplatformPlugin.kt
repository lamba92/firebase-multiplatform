package com.github.lamba92.firebasemultiplatform.build

import com.jfrog.bintray.gradle.BintrayPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper

@Suppress("unused")
class FirebaseMultiplatformPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {

        apply<KotlinMultiplatformPluginWrapper>()
        apply<MavenPublishPlugin>()
        apply<BintrayPlugin>()
        apply<AndroidLibraryPlugin>()

        repositories {
            mavenCentral()
            google()
            jcenter()
            maven("https://kotlin.bintray.com/kotlinx")
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
                    artifactId = "${rootProject.name}-$artifactId"
                }
            }
        }

        publishing {
            configure(publications.withType<MavenPublication>()) {
                artifactId = "${rootProject.name}-$artifactId"
            }
        }

        val bintrayUsername = searchPropertyOrNull("bintrayUsername")
        val bintrayApiKey = searchPropertyOrNull("bintrayApiKey")

        if (bintrayApiKey != null && bintrayUsername != null)
            bintray {
                println("Publishing credentials are available. Setting up publication")
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
                publishing {
                    val publications = publications.names + "androidRelease"
                    setPublications(publications)
                    println("Set up publications names: $publications")
                }
            }
        else
            println("publishing credentials not found.")

    }

}
