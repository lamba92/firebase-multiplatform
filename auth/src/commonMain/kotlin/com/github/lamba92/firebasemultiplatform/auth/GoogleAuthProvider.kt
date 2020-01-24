package com.github.lamba92.firebasemultiplatform.auth

expect object GoogleAuthProvider {
    val GOOGLE_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredentials(idToken: String, accessToken: String? = null): AuthCredential

}