package com.github.lamba92.firebasemultiplatform.auth

fun PlatformSpecificFirebaseAuth.toMpp() =
    FirebaseAuth(this)

fun PlatformSpecificActionCodeResult.toMpp() =
    ActionCodeResult(this)

fun PlatformSpecificFirebaseUser.toMpp() =
    FirebaseUser(this)

fun PlatformSpecificAuthResult.toMpp() =
    AuthResult(this)

fun PlatformSpecificUserProfileChangeRequest.toMpp() =
    UserProfileChangeRequest(this)

fun PlatformSpecificFirebaseUserMetadata.toMpp() =
    FirebaseUserMetadata(this)

fun PlatformSpecificUserInfo.toMpp() =
    UserInfo(this)

fun PlatformSpecificGetTokenResults.toMpp() =
    GetTokenResults(this)

fun PlatformSpecificPhoneAuthProvider.toMpp() =
    PhoneAuthProvider(this)

fun PlatformSpecificPhoneAuthCredential.toMpp() =
    PhoneAuthCredential(this)
