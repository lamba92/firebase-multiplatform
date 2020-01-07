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