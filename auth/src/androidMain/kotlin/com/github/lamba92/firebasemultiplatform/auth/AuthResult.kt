package com.github.lamba92.firebasemultiplatform.auth

actual class AuthResult actual constructor(
    actual val delegate: PlatformSpecificAuthResult
) {

    actual val additionalUserInfo by lazy {
        delegate.additionalUserInfo?.let {
            AdditionalUserInfo(it.profile, it.providerId, it.username, it.isNewUser)
        }
    }

    actual val credentials by lazy {
        delegate.credential?.let { AuthCredential(it.provider, it.signInMethod) }
    }

    actual val user by lazy {
        delegate.user?.toMpp()
    }

}