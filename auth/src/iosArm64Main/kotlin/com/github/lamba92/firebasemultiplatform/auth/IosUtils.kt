package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.*
import platform.Foundation.NSError
import kotlin.coroutines.Continuation
import kotlin.coroutines.resumeWithException

fun FIRAuth.toMpp() =
    FirebaseAuth(this)

fun FIRActionCodeInfo.toMpp() =
    ActionCodeResult(this)

fun FIRAdditionalUserInfo.toMpp() =
    AdditionalUserInfo(this)

fun FIRAuthCredential.toMpp() =
    object : AuthCredential(this) {}

fun FIRAuthDataResult.toMpp() =
    AuthResult(this)

fun NSError.toThrowable(): Throwable =
    Throwable(localizedDescription)

fun <T> Continuation<T>.resumeWithException(exception: NSError) =
    resumeWithException(exception.toThrowable())