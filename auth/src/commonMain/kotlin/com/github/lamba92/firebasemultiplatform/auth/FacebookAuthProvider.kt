package com.github.lamba92.firebasemultiplatform.auth

expect object FacebookAuthProvider {
    val FACEBOOK_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredential(accessToken: String): AuthCredential
}