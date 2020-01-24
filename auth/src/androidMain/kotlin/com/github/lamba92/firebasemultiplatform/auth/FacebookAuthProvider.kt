package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.FacebookAuthProvider

actual object FacebookAuthProvider {

    actual val FACEBOOK_SIGN_IN_METHOD: String
        get() = FacebookAuthProvider.FACEBOOK_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = FacebookAuthProvider.PROVIDER_ID

    actual fun getCredential(accessToken: String) =
        FacebookAuthProvider.getCredential(accessToken).toMpp()

}