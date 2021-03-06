package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRGoogleAuthProvider
import com.google.firebase.FIRGoogleAuthProviderID
import com.google.firebase.FIRGoogleAuthSignInMethod

actual object GoogleAuthProvider {

    actual val GOOGLE_SIGN_IN_METHOD: String
        get() = FIRGoogleAuthSignInMethod

    actual val PROVIDER_ID: String
        get() = FIRGoogleAuthProviderID

    actual fun getCredentials(idToken: String, accessToken: String?) =
        accessToken?.let { FIRGoogleAuthProvider.credentialWithIDToken(idToken, it).toMpp() }
            ?: throw IllegalStateException("Platform iOS needs both parameters idToken " +
                    "and accessToken not null.")


}