@file:Suppress("UNUSED_VARIABLE")

import com.github.lamba92.firebasemultiplatform.build.firebase
import com.github.lamba92.firebasemultiplatform.build.kotlinx

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val coroutinesVersion: String by project
    val firebaseCommonAndroidVersion: String by project
    val firebaseJsVersion: String by project
    val firebaseKtVersion: String by project

    commonMain {
        dependencies {
            api(kotlin("stdlib-common"))
            api(kotlinx("coroutines-core", coroutinesVersion))
        }
    }

    androidMain {
        dependencies {

            api(kotlin("stdlib-jdk8"))
            api(firebase("common", firebaseCommonAndroidVersion))

        }
    }

    jsMain {
        dependencies {
            api(kotlin("stdlib-js"))
            api(npm("firebase", firebaseJsVersion))
        }
    }

}
