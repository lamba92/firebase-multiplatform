package com.github.lamba92.firebasemultiplatform.auth

actual object EmailAuthProvider {
    actual val EMAIL_LINK_SIGN_IN_METHOD: String
        get() = firebase.auth.EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD

    actual val EMAIL_PASSWORD_SIGN_IN_METHOD: String
        get() = firebase.auth.EmailAuthProvider.EMAIL_PASSWORD_SIGN_IN_METHOD

    actual val PROVIDER_ID: String
        get() = firebase.auth.EmailAuthProvider.PROVIDER_ID

    actual fun getCredentials(
        idToken: String,
        accessToken: String
    ) = firebase.auth.EmailAuthProvider.credential(idToken, accessToken).toMpp()

}