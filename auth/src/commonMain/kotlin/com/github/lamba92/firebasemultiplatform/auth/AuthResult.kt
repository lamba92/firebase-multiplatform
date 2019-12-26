package com.github.lamba92.firebasemultiplatform.auth

expect class AuthResult {

    val additionalUserInfo: AdditionalUserInfo?
    val credentials: AuthCredential?
    val user: FirebaseUser?

}