plugins {
    `kotlin-dsl`
}

gradlePlugin.plugins.create("firebase-multiplatform-gradle-plugin") {
    id = "firebase-multiplatform-gradle-plugin"
    implementationClass = "com.github.lamba92.firebasemultiplatform.build.FirebaseMultiplatformPlugin"
}

repositories {
    jcenter()
    google()
}

dependencies {
    val kotlinVersion: String by project
    val bintrayVersion: String by project
    val androidGradlePlugin: String by project
    api("org.jetbrains.kotlin", "kotlin-gradle-plugin", kotlinVersion)
    api("com.android.tools.build", "gradle", androidGradlePlugin)
    api("com.jfrog.bintray.gradle", "gradle-bintray-plugin", bintrayVersion)
    api("de.undercouch", "gradle-download-task", "4.0.2")
}