package com.github.lamba92.firebasemultiplatform.auth

expect object GithubAuthProvider {
    val GITHUB_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredentials(token: String): AuthCredential
}