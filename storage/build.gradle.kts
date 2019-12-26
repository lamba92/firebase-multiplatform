@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase
import com.github.lamba92.firebasemultiplatform.build.kotlinx

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseStorageAndroidVersion: String by project
    val kotlinxIoVersion: String by project

    val commonMain by getting {
        dependencies {
            api(project(":core"))
            api(kotlinx("io", kotlinxIoVersion))
        }
    }

    val androidMain by getting {
        dependencies {
            api(firebase("storage", firebaseStorageAndroidVersion))
            api(kotlinx("io-jvm", kotlinxIoVersion))
        }
    }

}