@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase
import com.github.lamba92.firebasemultiplatform.build.firebaseKt

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseStorageAndroidVersion: String by project
    val kotlinxIoVersion: String by project
    val firebaseKtVersion: String by project

    val androidMain by getting {
        dependencies {
            api(project(":core"))
            api(firebase("storage", firebaseStorageAndroidVersion))
        }
    }

    val iosArm64Main by getting {
        dependencies {
            api(project(":core"))
            api(firebaseKt("storage-iosarm64", firebaseKtVersion))
        }
    }

    val iosX64Main by getting {
        dependencies {
            api(project(":core"))
            api(firebaseKt("storage-iosx64", firebaseKtVersion))
        }
    }

}