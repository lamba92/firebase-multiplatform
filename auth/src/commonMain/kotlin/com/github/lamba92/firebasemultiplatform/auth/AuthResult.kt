package com.github.lamba92.firebasemultiplatform.auth

expect class AuthResult(
    delegate: PlatformSpecificAuthResult
) {

    val delegate: PlatformSpecificAuthResult
    val additionalUserInfo: AdditionalUserInfo?
    val credentials: AuthCredential?
    val user: FirebaseUser?
}