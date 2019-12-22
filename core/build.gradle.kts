val kotlin_version: String by extra
plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin {

    sourceSets {

        val androidMain by getting {
            dependencies {

                val coroutinesVersion: String by project
                val playServicesTasksVersion: String by project

                api(kotlin("stdlib-jdk8"))

                api("com.google.android.gms:play-services-tasks:$playServicesTasksVersion")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

            }
        }
    }

}
