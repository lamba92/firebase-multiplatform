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

fun FIRUser.toMpp() =
    FirebaseUser(this)

fun FIRUserMetadata.toMpp() =
    FirebaseUserMetadata(this)

fun FIRUserInfoProtocol.toMpp() =
    UserInfo(this)

fun FIRAuthTokenResult.toMpp() =
    GetTokenResults(this)

fun FIROAuthProvider.toMpp() =
    OAuthProvider(this)

fun FIRPhoneAuthCredential.toMpp() =
    PhoneAuthCredential(this)

fun FIRPhoneAuthProvider.toMpp() =
    PhoneAuthProvider(this)