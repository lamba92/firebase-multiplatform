package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.*

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