package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRUserInfoProtocol

actual class UserInfo(val delegate: FIRUserInfoProtocol) {
    actual val displayName: String?
        get() = delegate.displayName
    actual val email: String?
        get() = delegate.email
    actual val phoneNumber: String?
        get() = delegate.phoneNumber
    actual val photoUrl: String?
        get() = delegate.photoURL?.absoluteString
    actual val providerId: String
        get() = delegate.providerID
    actual val uid: String
        get() = delegate.uid
}