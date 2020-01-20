package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.UserCredential

actual class AuthResult(val delegate: UserCredential) {

    actual val additionalUserInfo: AdditionalUserInfo?
        get() = delegate.additionalUserInfo?.toMpp()
    actual val credentials: AuthCredential?
        get() = delegate.credential?.toMpp()

}