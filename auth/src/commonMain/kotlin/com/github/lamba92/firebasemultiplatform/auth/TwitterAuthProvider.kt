package com.github.lamba92.firebasemultiplatform.auth

expect object TwitterAuthProvider {
    val TWITTER_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredential(token: String, secret: String): AuthCredential
}