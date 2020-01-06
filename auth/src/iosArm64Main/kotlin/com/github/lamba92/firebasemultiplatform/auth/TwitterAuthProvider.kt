package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRTwitterAuthProvider
import com.google.firebase.FIRTwitterAuthProviderID
import com.google.firebase.FIRTwitterAuthSignInMethod

actual object TwitterAuthProvider {
    actual val TWITTER_SIGN_IN_METHOD: String
        get() = FIRTwitterAuthSignInMethod
    actual val PROVIDER_ID: String
        get() = FIRTwitterAuthProviderID

    actual fun getCredential(token: String, secret: String) =
        FIRTwitterAuthProvider.credentialWithToken(token, secret).toMpp()

}