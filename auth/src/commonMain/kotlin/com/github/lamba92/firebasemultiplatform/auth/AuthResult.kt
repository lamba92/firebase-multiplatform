package com.github.lamba92.firebasemultiplatform.auth

interface AuthResult {

    val delegate: PlatformSpecificAuthResult
    val additionalUserInfo: AdditionalUserInfo?
    val credentials: AuthCredential?
    val user: FirebaseUser?

}