package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.TwitterAuthProvider

actual object TwitterAuthProvider {

    actual val TWITTER_SIGN_IN_METHOD: String
        get() = TwitterAuthProvider.TWITTER_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = TwitterAuthProvider.PROVIDER_ID

    actual fun getCredential(
        token: String,
        secret: String
    ) = TwitterAuthProvider.getCredential(token, secret).toMpp()

}