package com.github.lamba92.firebasemultiplatform.auth

actual object TwitterAuthProvider {

    actual val TWITTER_SIGN_IN_METHOD: String
        get() = firebase.auth.TwitterAuthProvider.TWITTER_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = firebase.auth.TwitterAuthProvider.PROVIDER_ID

    actual fun getCredential(token: String, secret: String) =
        firebase.auth.TwitterAuthProvider.credential(token, secret).toMpp()

}