@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin {

    sourceSets {

        val coroutinesVersion: String by project
        val firebaseCommonAndroidVersion: String by project
        val firebaseJsVersion: String by project

        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion")
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