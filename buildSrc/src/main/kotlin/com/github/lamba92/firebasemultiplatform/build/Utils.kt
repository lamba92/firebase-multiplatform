package com.github.lamba92.firebasemultiplatform.build

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.jfrog.bintray.gradle.BintrayExtension
import org.gradle.api.Project
import org.gradle.api.provider.ListProperty
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.tasks.Sync
import org.gradle.kotlin.dsl.closureOf
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import kotlin.reflect.KProperty

@Suppress("unused")
fun KotlinDependencyHandler.firebase(module: String, version: String) =
    "com.google.firebase:firebase-$module:$version"

@Suppress("unused")
fun KotlinDependencyHandler.lamba(module: String, version: String) =
    "com.github.lamba92:$module:$version"

@Suppress("unused")
fun KotlinDependencyHandler.firebaseKt(module: String, version: String) =
    "com.github.lamba92:kt-firebase-$module:$version"

@Suppress("unused")
fun KotlinDependencyHandler.firebaseMpp(module: String, version: String) =
    "com.github.lamba92:firebase-multiplatform-$module:$version"

@Suppress("unused")
fun KotlinDependencyHandler.kotlinx(module: String, version: String) =
    "org.jetbrains.kotlinx:kotlinx-$module:$version"

fun BintrayExtension.setPublications(names: Iterable<String>) =
    setPublications(*names.toList().toTypedArray())

fun BintrayExtension.setPublications(builder: () -> Iterable<String>) =
    setPublications(builder())

fun String.suffixIfNot(suffix: String) =
    if (this.endsWith(suffix)) this else "$this$suffix"

fun String.prefixIfNot(prefix: String) =
    if (this.startsWith(prefix)) this else "$prefix$this"

fun Project.log(message: String) =
    println("> project $name: ${message.suffixIfNot(".")}")

operator fun <T> ListProperty<T>.getValue(receiver: Any?, property: KProperty<*>): List<T> =
    get()

operator fun <T> ListProperty<T>.setValue(receiver: Any?, property: KProperty<*>, value: Iterable<T>) =
    set(value)

val Project.extractFirebaseIosZip
    get() = rootProject.tasks.named<Sync>("extractFirebaseIosZip").get()

inline fun <T> Iterable<T>.applyEach(action: T.() -> Unit) =
    forEach(action)
