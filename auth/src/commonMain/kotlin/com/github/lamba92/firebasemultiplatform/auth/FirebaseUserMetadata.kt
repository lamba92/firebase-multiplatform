package com.github.lamba92.firebasemultiplatform.auth

expect class FirebaseUserMetadata(
    delegate: PlatformSpecificFirebaseUserMetadata
) {
    val delegate: PlatformSpecificFirebaseUserMetadata
    val creationTimestamp: Long
    val lastSignInTimestamp: Long
}
