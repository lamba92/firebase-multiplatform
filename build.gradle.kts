import de.undercouch.gradle.tasks.download.Download
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
    id("firebase-multiplatform-gradle-plugin") apply false
    id("de.undercouch.download")
}

allprojects {
    group = "com.github.lamba92"
    version = System.getenv("TRAVIS_TAG") ?: "0.0.4-3"
}

NodeJsRootPlugin.apply(project).run {
    versions.dukat.version = "0.0.24"
}

val downloadFirebaseIos = task<Download>("downloadFirebaseIosZip") {
    group = "ios firebase setup"

    val firebaseIosZipVersion: String by project
    val fileName = "Firebase-$firebaseIosZipVersion.zip"

    src("https://dl.google.com/firebase/sdk/ios/6_14_0/$fileName")
    dest(file("$buildDir/firebaseios/$fileName"))
}

task<Copy>("extractFirebaseIosZip") {
    dependsOn(downloadFirebaseIos)
    group = "ios firebase setup"
    from(zipTree(downloadFirebaseIos.dest))
    into("$buildDir/firebaseios/${downloadFirebaseIos.dest.nameWithoutExtension}")
}