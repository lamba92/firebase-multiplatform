package com.github.lamba92.firebasemultiplatform.auth

expect abstract class AuthCredential {
    val provider: String
    val signInMethod: String
}