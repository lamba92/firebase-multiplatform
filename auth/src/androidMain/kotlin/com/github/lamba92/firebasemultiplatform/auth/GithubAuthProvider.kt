package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.GithubAuthProvider

actual object GithubAuthProvider {

    actual val GITHUB_SIGN_IN_METHOD: String
        get() = GithubAuthProvider.GITHUB_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = GithubAuthProvider.PROVIDER_ID

    actual fun getCredentials(token: String) =
        GithubAuthProvider.getCredential(token).toMpp()
}