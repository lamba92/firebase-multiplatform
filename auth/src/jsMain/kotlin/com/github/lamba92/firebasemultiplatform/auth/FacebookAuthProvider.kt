package com.github.lamba92.firebasemultiplatform.auth

actual object FacebookAuthProvider {

    actual val FACEBOOK_SIGN_IN_METHOD: String
        get() = firebase.auth.FacebookAuthProvider.FACEBOOK_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = firebase.auth.FacebookAuthProvider.PROVIDER_ID

    actual fun getCredential(accessToken: String) =
        firebase.auth.FacebookAuthProvider.credential(accessToken).toMpp()

}