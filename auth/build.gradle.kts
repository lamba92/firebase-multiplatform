@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase
import com.github.lamba92.firebasemultiplatform.build.firebaseKt

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseAuthAndroidVersion: String by project
    val firebaseKtVersion: String by project

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

    val iosArm64Main by getting {
        dependencies {
            api(firebaseKt("auth-iosarm64", firebaseKtVersion))
        }
    }

    val iosX64Main by getting {
        dependencies {
            api(firebaseKt("auth-iosx64", firebaseKtVersion))
        }
    }

}
