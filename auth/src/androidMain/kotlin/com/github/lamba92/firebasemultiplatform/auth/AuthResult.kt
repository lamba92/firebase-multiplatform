package com.github.lamba92.firebasemultiplatform.auth

actual class AuthResult(
    val delegate: PlatformSpecificAuthResult
) {

    actual val additionalUserInfo: AdditionalUserInfo?
        get() = delegate.additionalUserInfo?.toMpp()
    actual val credentials: AuthCredential?
        get() = delegate.credential?.toMpp()

}