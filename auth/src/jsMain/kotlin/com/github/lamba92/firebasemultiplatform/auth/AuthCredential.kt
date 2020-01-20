package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.AuthCredential

actual abstract class AuthCredential(val delegate: AuthCredential) {
    actual val provider: String
        get() = delegate.providerId
    actual val signInMethod: String
        get() = delegate.signInMethod
}