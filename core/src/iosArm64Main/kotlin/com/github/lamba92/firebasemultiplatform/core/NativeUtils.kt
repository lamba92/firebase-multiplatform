package com.github.lamba92.firebasemultiplatform.core

import com.google.firebase.FIRApp
import com.google.firebase.FIROptions
import platform.Foundation.NSError
import kotlin.coroutines.Continuation
import kotlin.coroutines.resumeWithException

fun FIRApp.toMpp() =
    FirebaseApp(this)

fun FIROptions.toMpp() =
    FirebaseOptions(this)

fun NSError.toThrowable(): Throwable =
    Throwable(localizedDescription)

fun <T> Continuation<T>.resumeWithException(exception: NSError) =
    resumeWithException(exception.toThrowable())