package com.github.lamba92.firebasemultiplatform.auth

actual object GithubAuthProvider {

    actual val GITHUB_SIGN_IN_METHOD: String
        get() = firebase.auth.GithubAuthProvider.GITHUB_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = firebase.auth.GithubAuthProvider.PROVIDER_ID

    actual fun getCredentials(token: String) =
        firebase.auth.GithubAuthProvider.credential(token).toMpp()

}