package com.github.lamba92.firebasemultiplatform.build

import com.jfrog.bintray.gradle.BintrayPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.apply
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper

@Suppress("unused")
class FirebaseMultiplatformPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {

        apply<KotlinMultiplatformPluginWrapper>()
        apply<MavenPublishPlugin>()
        apply<BintrayPlugin>()
        apply<AndroidLibraryPlugin>()

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
            }
        }

        bintray {
            user = searchProperty("bintrayUsername")
            key = searchProperty("bintrayApiKey")
            pkg {
                version {
                    name = project.version.toString()
                }
                repo = "com.github.lamba92"
                name = "firebase-multiplatform"
                setLicenses("Apache-2.0")
                vcsUrl = "https://github.com/lamba92/firebase-multiplatform"
                issueTrackerUrl = "https://github.com/lamba92/firebase-multiplatform/issues"
            }
            publish = true
            setPublications("android", "js", "kotlinMultiplatform")
        }

    }

}