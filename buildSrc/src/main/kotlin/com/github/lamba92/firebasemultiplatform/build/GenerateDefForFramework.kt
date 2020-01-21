package com.github.lamba92.firebasemultiplatform.build

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import org.gradle.kotlin.dsl.*
import java.io.File

@CacheableTask
open class GenerateDefForFramework : DefaultTask() {

    @get:OutputFile
    var output by project.objects.property<File>()

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    var framework by project.objects.property<File>()

    @get:Input
    var packageName by project.objects.property<String>()

    @get:Input
    var buildStatic by project.objects.property<Boolean>()

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    var libraryPaths by project.objects.listProperty<File>()

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    var staticLibraries by project.objects.listProperty<File>()

    init {
        buildStatic = false
        group = "interop"
    }

    @TaskAction
    private fun generate(): Unit = with(project) {
        val headersNames = File(framework, "Headers")
            .walkTopDown()
            .filter { it.isFile && it.extension == "h" }
            .map { it.name }
            .joinToString(" ")

        val defContent = buildString {
            appendln("language = Objective-C")
            appendln("package = $packageName")
            appendln("headers = $headersNames")
            if (buildStatic) {
                appendln("staticLibraries = ${staticLibraries.joinToString(" ") { it.name }}")
                appendln("libraryPaths = ${libraryPaths.joinToString(" ") { it.absolutePath }}")
            }
        }

        with(output) {
            if (exists())
                delete()
            parentFile.mkdirs()
            createNewFile()
            writeText(defContent)
        }

    }

}