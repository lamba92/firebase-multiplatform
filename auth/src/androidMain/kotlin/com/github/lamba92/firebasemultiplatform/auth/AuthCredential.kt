package com.github.lamba92.firebasemultiplatform.auth

actual abstract class AuthCredential(
    open val delegate: PlatformSpecificAuthCredential
) {
    actual val provider: String
        get() = delegate.provider
    actual val signInMethod: String
        get() = delegate.signInMethod

}