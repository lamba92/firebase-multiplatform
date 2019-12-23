package com.github.lamba92.firebasemultiplatform.auth

expect abstract class AuthCredential(delegate: PlatformSpecificAuthCredential) {
    open val delegate: PlatformSpecificAuthCredential
    val provider: String
    val signInMethod: String
}