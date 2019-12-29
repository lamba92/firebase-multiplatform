import de.undercouch.gradle.tasks.download.Download
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import java.io.IOException
import java.util.zip.ZipFile

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

val firebaseIosSetupFolderName = "$buildDir/firebaseIosSetup"

val downloadFirebaseIos = task<Download>("downloadFirebaseIosZip") {

    group = "ios firebase setup"

    val firebaseIosZipVersion: String by project

    val fileName = "Firebase-$firebaseIosZipVersion.zip"
    val file = file("$firebaseIosSetupFolderName/$fileName")

    onlyIf {
        if (file.exists())
            try {
                ZipFile(file)
                println("Skipping $fileName download. It seems ok.")
                false
            } catch (e: IOException) {
                true
            }
        else
            true
    }

    src("https://dl.google.com/firebase/sdk/ios/6_14_0/$fileName")
    dest(file)

}

val firebaseExtract = task<Sync>("extractFirebaseIosZip") {
    dependsOn(downloadFirebaseIos)
    group = "ios firebase setup"
    from(zipTree(downloadFirebaseIos.dest).matching { include("**/*.framework/**") }) {
        val frameRegex = Regex(".*[\\/\\\\](.*\\.framework[\\/\\\\].*)")
        eachFile {
            val newPath = frameRegex.matchEntire(path)!!.groups[1]!!.value
            println("$path->$newPath")
            path = newPath
        }
    }
    into("$firebaseIosSetupFolderName/${downloadFirebaseIos.dest.nameWithoutExtension}")
}

subprojects {
    tasks.withType<CInteropProcess> {
        dependsOn(firebaseExtract)
    }
}