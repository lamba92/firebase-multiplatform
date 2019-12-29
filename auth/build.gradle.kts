@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseAuthAndroidVersion: String by project

    val commonMain by getting {
        dependencies {
            api(project(":core"))
        }
    }

    val androidMain by getting {
        dependencies {
            api(firebase("auth", firebaseAuthAndroidVersion))
        }
    }

}