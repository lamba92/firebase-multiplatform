package com.github.lamba92.firebasemultiplatform.auth

actual class FirebaseUserMetadata actual constructor(
    actual val delegate: PlatformSpecificFirebaseUserMetadata
) {

    actual val creationTimestamp: Long
        get() = delegate.creationTimestamp
    actual val lastSignInTimestamp: Long
        get() = delegate.lastSignInTimestamp

}