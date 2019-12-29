package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRAuthCredential

actual abstract class AuthCredential(
    val delegate: FIRAuthCredential
) {
    actual val provider: String
        get() = delegate.provider

    actual val signInMethod: String
        get() = delegate.provider

}
