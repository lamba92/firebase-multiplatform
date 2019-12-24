package com.github.lamba92.firebasemultiplatform.auth

expect object GoogleAuthProvider {
    val GITHUB_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredentials(idToken: String, accessToken: String): AuthCredential
    fun getCredentialsWithIdToken(idToken: String): AuthCredential
    fun getCredentialsWithAccessToken(accessToken: String): AuthCredential

}