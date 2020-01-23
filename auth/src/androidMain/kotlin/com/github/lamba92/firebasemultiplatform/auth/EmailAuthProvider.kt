package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.EmailAuthProvider

actual object EmailAuthProvider {
    actual val EMAIL_LINK_SIGN_IN_METHOD: String
        get() = EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD

    actual val EMAIL_PASSWORD_SIGN_IN_METHOD: String
        get() = EmailAuthProvider.EMAIL_PASSWORD_SIGN_IN_METHOD

    actual val PROVIDER_ID: String
        get() = EmailAuthProvider.PROVIDER_ID

    actual fun getCredentials(
        idToken: String,
        accessToken: String
    ) = EmailAuthProvider.getCredential(idToken, accessToken).toMpp()

}