package com.github.lamba92.firebasemultiplatform.auth

actual object GoogleAuthProvider {

    actual val GOOGLE_SIGN_IN_METHOD: String
        get() = firebase.auth.GoogleAuthProvider.GOOGLE_SIGN_IN_METHOD

    actual val PROVIDER_ID: String
        get() = firebase.auth.GoogleAuthProvider.PROVIDER_ID

    actual fun getCredentials(idToken: String, accessToken: String?) =
        firebase.auth.GoogleAuthProvider.credential(idToken, accessToken).toMpp()

}