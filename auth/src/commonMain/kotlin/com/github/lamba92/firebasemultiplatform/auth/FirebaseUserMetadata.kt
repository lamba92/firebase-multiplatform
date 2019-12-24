package com.github.lamba92.firebasemultiplatform.auth

interface FirebaseUserMetadata {
    val delegate: PlatformSpecificFirebaseUserMetadata
    val creationTimestamp: Long
    val lastSignInTimestamp: Long
}
