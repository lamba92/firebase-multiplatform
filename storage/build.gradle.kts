@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseStorageAndroidVersion: String by project

    commonMain {
        dependencies {
            api(project(":core"))
        }
    }

    androidMain {
        dependencies {
            api(firebase("storage", firebaseStorageAndroidVersion))
        }
    }

}
