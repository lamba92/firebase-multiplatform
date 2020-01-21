package com.github.lamba92.firebasemultiplatform.auth

actual class FirebaseUserInfo(
    val delegate: PlatformSpecificUserInfo
) {
    actual val displayName: String?
        get() = delegate.displayName
    actual val email: String?
        get() = delegate.email
    actual val phoneNumber: String?
        get() = delegate.phoneNumber
    actual val photoUrl: String?
        get() = delegate.photoUrl?.toString()
    actual val providerId: String
        get() = delegate.providerId
    actual val uid: String
        get() = delegate.uid

}