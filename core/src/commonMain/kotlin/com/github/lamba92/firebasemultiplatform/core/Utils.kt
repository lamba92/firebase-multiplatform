@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.core

fun PlatformSpecificFirebaseApp.toMpp() =
    FirebaseApp(this)

fun PlatformSpecificFirebaseOptions.toMpp() =
    FirebaseOptions(this)

fun FirebaseOptions.Builder.build(action: FirebaseOptions.Builder.() -> Unit) =
    FirebaseOptions.Builder().apply(action).build()

operator fun FirebaseOptions.Builder.Companion.invoke(action: FirebaseOptions.Builder.() -> Unit) =
    FirebaseOptions.Builder().build(action)

operator fun FirebaseOptions.Companion.invoke(action: FirebaseOptions.Builder.() -> Unit) =
    FirebaseOptions.Builder(action)

fun FirebaseApp.Companion.initializeApp(action: FirebaseOptions.Builder.() -> Unit) =
    initializeApp(FirebaseOptions(action))

fun FirebaseApp.Companion.initializeApp(name: String, action: FirebaseOptions.Builder.() -> Unit) =
    initializeApp(FirebaseOptions(action), name)
