@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.core

import kotlin.coroutines.Continuation

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

fun Continuation<Unit>.resume(): Unit =
    resumeWith(Result.success(Unit))
