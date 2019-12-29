@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase
import com.github.lamba92.firebasemultiplatform.build.kotlinx
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

val firebaseExtract by rootProject.tasks.named<Sync>("extractFirebaseIosZip")

kotlin {

    iosArm64()
    iosX64()
    macosX64()

    targets.withType<KotlinNativeTarget> {
        compilations["main"].cinterops {
            create("firebaseCore") {

                val frameworksFolderPath = firebaseExtract.destinationDir.absolutePath

                defFile = file("cinterops/firebaseCore.def")

                includeDirs(file("$frameworksFolderPath/FirebaseCore.framework/Headers"))
                compilerOpts("-F$frameworksFolderPath")
                linkerOpts("-F$frameworksFolderPath")

            }
        }
        binaries {
            framework()
        }
    }

    sourceSets {

        val coroutinesVersion: String by project
        val firebaseCommonAndroidVersion: String by project
        val firebaseJsVersion: String by project

        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
                api(kotlinx("coroutines-core-common", coroutinesVersion))
            }
        }

        val androidMain by getting {
            dependencies {

                api(kotlin("stdlib-jdk8"))

                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
                api(firebase("common", firebaseCommonAndroidVersion))

            }
        }

//        val jsMain by getting {
//            dependencies {
//
//                api(kotlin("stdlib-js"))
//                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
//                api(npm("firebase", firebaseJsVersion))
//
//            }
//        }

    }

}
