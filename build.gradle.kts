import de.undercouch.gradle.tasks.download.Download
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import java.util.zip.ZipFile

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

val firebaseIosSetupFolderName = "$buildDir/firebaseIosSetup"

val downloadFirebaseIos = task<Download>("downloadFirebaseIosZip") {

    group = "ios firebase setup"

    val firebaseDownloadUrl: String by project

    val fileName = firebaseDownloadUrl.substringAfterLast("/")
    val file = file("$firebaseIosSetupFolderName/$fileName")

    onlyIf {
        if (file.exists())
            try {
                ZipFile(file)
                println("${file.absolutePath}:\n - Skipping $fileName download. Zip header integrity is fine.")
                false
            } catch (e: java.io.IOException) {
                true
            }
        else
            true
    }

    src(firebaseDownloadUrl)
    dest(file)
}

val firebaseExtract = task<Sync>("extractFirebaseIosZip") {
    dependsOn(downloadFirebaseIos)
    group = "ios firebase setup"
    from(zipTree(downloadFirebaseIos.dest).matching { include("**/*.framework/**") }) {
        val frameRegex = Regex(".*[\\/\\\\](.*\\.framework[\\/\\\\].*)")
        eachFile {
            val newPath = frameRegex.matchEntire(path)!!.groups[1]!!.value
            path = newPath
        }
    }
    into("$firebaseIosSetupFolderName/${downloadFirebaseIos.dest.nameWithoutExtension}")
}