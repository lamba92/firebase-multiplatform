package com.github.lamba92.firebasemultiplatform.auth

expect object EmailAuthProvider {
    val EMAIL_LINK_SIGN_IN_METHOD: String
    val EMAIL_PASSWORD_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredentials(idToken: String, accessToken: String): AuthCredential

}