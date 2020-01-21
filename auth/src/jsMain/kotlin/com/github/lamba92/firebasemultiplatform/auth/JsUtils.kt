package com.github.lamba92.firebasemultiplatform.auth

import firebase.User
import firebase.UserInfo
import firebase.auth.*

fun Auth.toMpp() =
    FirebaseAuth(this)

fun Error.asThrowable() =
    Throwable("Code: $code | $message")

fun ActionCodeInfo.toMpp() =
    ActionCodeResult(this)

fun firebase.auth.AuthCredential.toMpp() =
    object : AuthCredential(this) {}

fun firebase.auth.AdditionalUserInfo.toMpp() =
    AdditionalUserInfo(this)

fun UserCredential.toMpp() =
    AuthResult(this)

fun User.toMpp() =
    FirebaseUser(this)

fun UserMetadata.toMpp() =
    FirebaseUserMetadata(this)

fun IdTokenResult.toMpp() =
    GetTokenResults(this)

fun UserInfo.toMpp() =
    FirebaseUserInfo(this)

fun PhoneAuthProvider_Instance.toMpp() =
    PhoneAuthProvider(this)