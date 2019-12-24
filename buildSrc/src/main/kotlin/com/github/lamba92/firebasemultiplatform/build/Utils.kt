package com.github.lamba92.firebasemultiplatform.build

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.jfrog.bintray.gradle.BintrayExtension
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.closureOf
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

typealias AndroidLibraryPlugin = LibraryPlugin
typealias AndroidLibraryExtension = LibraryExtension

@Suppress("FunctionName")
fun Project.android(action: AndroidLibraryExtension.() -> Unit) =
    extensions.configure(action)

@Suppress("FunctionName")
fun Project.kotlin(action: KotlinMultiplatformExtension.() -> Unit) =
    extensions.configure(action)

@Suppress("FunctionName")
fun Project.bintray(action: BintrayExtension.() -> Unit) =
    extensions.configure(action)

@Suppress("FunctionName")
fun Project.publishing(action: PublishingExtension.() -> Unit) =
    extensions.configure(action)

val Project.publishing
    get() = extensions.findByType<PublishingExtension>()!!

fun BintrayExtension.pkg(action: BintrayExtension.PackageConfig.() -> Unit) {
    pkg(closureOf(action))
}

fun BintrayExtension.PackageConfig.version(action: BintrayExtension.VersionConfig.() -> Unit) {
    version(closureOf(action))
}

fun Project.searchPropertyOrNull(propertyName: String): String? =
    findProperty(propertyName) as String? ?: System.getenv(propertyName)

fun Project.searchProperty(propertyName: String) =
    searchPropertyOrNull(propertyName)
        ?: throw IllegalArgumentException(
            "Cannot find $propertyName in either " +
                    "gradle/properties or environmental variables"
        )

fun Project.searchProperties(vararg propertyNames: String) =
    propertyNames.associate { it to searchPropertyOrNull(it) }

fun AndroidLibraryExtension.alignSourcesForKotlinMultiplatformPlugin(project: Project) =
    sourceSets.all {
        java.srcDirs(project.file("src/android${name.capitalize()}/kotlin"))
        res.srcDirs(project.file("src/android${name.capitalize()}/res"))
        resources.srcDirs(project.file("src/android${name.capitalize()}/resources"))
        manifest.srcFile(project.file("src/android${name.capitalize()}/AndroidManifest.xml"))
    }

fun KotlinDependencyHandler.firebase(module: String, version: String) =
    "com.google.firebase:firebase-$module:$version"

fun BintrayExtension.setPublications(names: Iterable<String>) =
    setPublications(*names.toList().toTypedArray())