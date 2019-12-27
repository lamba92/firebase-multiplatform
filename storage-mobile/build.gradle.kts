@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.kotlinx

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseStorageAndroidVersion: String by project
    val kotlinxIoVersion: String by project

    val commonMain by getting {
        dependencies {
            api(project(":storage"))
            api(kotlinx("io", kotlinxIoVersion))
        }
    }

    val androidMain by getting {
        dependencies {
            api(project(":storage"))
            api(kotlinx("io-jvm", kotlinxIoVersion))
        }
    }

}