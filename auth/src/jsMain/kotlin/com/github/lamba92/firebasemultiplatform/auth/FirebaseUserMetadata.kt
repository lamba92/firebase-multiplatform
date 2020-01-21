package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.UserMetadata

actual class FirebaseUserMetadata(val delegate: UserMetadata) {
    actual val creationTimestamp: Long
        get() = delegate.creationTime!!.toLong()
    actual val lastSignInTimestamp: Long
        get() = delegate.lastSignInTime!!.toLong()
}