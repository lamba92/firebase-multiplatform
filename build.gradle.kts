import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    id("firebase-multiplatform-gradle-plugin") apply false
}

allprojects {
    group = "com.github.lamba92"
    version = System.getenv("TRAVIS_TAG").let {
        if (it.isNullOrBlank()) "0.0.5" else it
    }
}

NodeJsRootPlugin.apply(project).run {
    versions.dukat.version = "0.0.25"
}