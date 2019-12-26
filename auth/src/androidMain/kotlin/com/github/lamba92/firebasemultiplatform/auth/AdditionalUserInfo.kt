package com.github.lamba92.firebasemultiplatform.auth

actual class AdditionalUserInfo(
    val delegate: PlatformSpecificAdditionalUserInfo
) {
    actual val profile: Map<String, Any>?
        get() = delegate.profile
    actual val providerId: String?
        get() = delegate.providerId
    actual val username: String?
        get() = delegate.username
    actual val isNewUser: Boolean
        get() = delegate.isNewUser

}