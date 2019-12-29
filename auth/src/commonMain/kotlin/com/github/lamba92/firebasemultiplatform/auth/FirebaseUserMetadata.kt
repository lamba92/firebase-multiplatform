package com.github.lamba92.firebasemultiplatform.auth

expect class FirebaseUserMetadata {
    val creationTimestamp: Long
    val lastSignInTimestamp: Long
}
