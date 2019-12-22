import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin {

    sourceSets {
        val androidMain by getting {
            dependencies {

                val firebaseAuthAndroidVersion: String by project

                implementation(project(":core"))
                implementation(firebase("auth", firebaseAuthAndroidVersion))
            }
        }
    }

}