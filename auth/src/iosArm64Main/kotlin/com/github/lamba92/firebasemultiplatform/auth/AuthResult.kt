package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRAuthDataResult

actual class AuthResult(
    val delegate: FIRAuthDataResult
) {
    actual val additionalUserInfo: AdditionalUserInfo?
        get() = delegate.additionalUserInfo?.toMpp()
    actual val credentials: AuthCredential?
        get() = delegate.credential?.toMpp()
}