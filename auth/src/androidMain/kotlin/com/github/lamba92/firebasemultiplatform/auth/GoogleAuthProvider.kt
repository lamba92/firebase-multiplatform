package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.GoogleAuthProvider

actual object GoogleAuthProvider {

    actual val GOOGLE_SIGN_IN_METHOD: String
        get() = GoogleAuthProvider.GOOGLE_SIGN_IN_METHOD

    actual val PROVIDER_ID: String
        get() = GoogleAuthProvider.PROVIDER_ID

    actual fun getCredentials(idToken: String, accessToken: String) =
        GoogleAuthProvider.getCredential(idToken, accessToken).toMpp()

    fun getCredentialsWithIdToken(idToken: String) =
        GoogleAuthProvider.getCredential(idToken, null).toMpp()

    fun getCredentialsWithAccessToken(accessToken: String) =
        GoogleAuthProvider.getCredential(null, accessToken).toMpp()

}