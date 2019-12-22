plugins {
    id("firebase-multiplatform-gradle-plugin") apply false
}

allprojects {
    group = "org.example"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}