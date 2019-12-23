package com.github.lamba92.firebasemultiplatform.auth

expect class FirebaseUser(
    delegate: PlatformSpecificFirebaseUser
) {
    val delegate: PlatformSpecificFirebaseUser
}