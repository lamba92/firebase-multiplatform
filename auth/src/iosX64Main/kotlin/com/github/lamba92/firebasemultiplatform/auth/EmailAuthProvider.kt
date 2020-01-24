package com.github.lamba92.firebasemultiplatform.auth

actual object EmailAuthProvider {

    actual val EMAIL_LINK_SIGN_IN_METHOD: String
        get() = TODO("Not yet implemented")

    actual val EMAIL_PASSWORD_SIGN_IN_METHOD: String
        get() = TODO("Not yet implemented")

    actual val PROVIDER_ID: String
        get() = TODO("Not yet implemented")

    actual fun getCredentials(
        idToken: String,
        accessToken: String
    ): AuthCredential {
        TODO("Not yet implemented")
    }

}