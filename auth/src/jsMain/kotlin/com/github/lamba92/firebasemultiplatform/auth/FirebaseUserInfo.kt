package com.github.lamba92.firebasemultiplatform.auth

import firebase.UserInfo

actual class FirebaseUserInfo(val delegate: UserInfo) {

    actual val displayName: String?
        get() = delegate.displayName
    actual val email: String?
        get() = delegate.email
    actual val phoneNumber: String?
        get() = delegate.phoneNumber
    actual val photoUrl: String?
        get() = delegate.photoURL
    actual val providerId: String
        get() = delegate.providerId
    actual val uid: String
        get() = delegate.uid

}