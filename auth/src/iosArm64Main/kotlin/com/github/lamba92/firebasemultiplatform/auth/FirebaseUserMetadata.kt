package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRUserMetadata

actual class FirebaseUserMetadata(val delegate: FIRUserMetadata) {
    actual val creationTimestamp: Long
        get() = delegate.creationDate!!.timeIntervalSinceReferenceDate.toLong()
    actual val lastSignInTimestamp: Long
        get() = delegate.lastSignInDate!!.timeIntervalSinceReferenceDate.toLong()
}