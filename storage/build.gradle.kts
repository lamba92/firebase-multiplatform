@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.bindFirebaseFramework
import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin {

    ios {
        compilations["main"].cinterops {
            bindFirebaseFramework("FirebaseStorage", project)
        }
    }

    sourceSets {
        val firebaseStorageAndroidVersion: String by project
        val kotlinxIoVersion: String by project

        val commonMain by getting {
            dependencies {
                api(project(":core"))
            }
        }

        val androidMain by getting {
            dependencies {
                api(project(":core"))
                api(firebase("storage", firebaseStorageAndroidVersion))
            }
        }

    }

}