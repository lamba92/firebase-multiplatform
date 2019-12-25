import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    id("firebase-multiplatform-gradle-plugin") apply false
}

allprojects {
    group = "com.github.lamba92"
    version = "0.0.2"
}

NodeJsRootPlugin.apply(project).run {
    versions.dukat.version = "0.0.24"
}