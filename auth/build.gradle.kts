import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin {

    sourceSets {

        val commonMain by getting {
            dependencies {
                api(project(":core"))
            }
        }

        val androidMain by getting {
            dependencies {

                val firebaseAuthAndroidVersion: String by project

                api(project(":core"))
                api(firebase("auth", firebaseAuthAndroidVersion))

            }
        }
    }

}