package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRGitHubAuthProvider
import com.google.firebase.FIRGitHubAuthProviderID
import com.google.firebase.FIRGitHubAuthSignInMethod

actual object GithubAuthProvider {
    actual val GITHUB_SIGN_IN_METHOD: String
        get() = FIRGitHubAuthSignInMethod
    actual val PROVIDER_ID: String
        get() = FIRGitHubAuthProviderID

    actual fun getCredentials(token: String) =
        FIRGitHubAuthProvider.credentialWithToken(token).toMpp()

}