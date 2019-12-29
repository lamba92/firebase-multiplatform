package com.github.lamba92.firebasemultiplatform.auth

expect class OAuthProvider : FederatedAuthProvider {

    val providerId: String?

    companion object {
        @Deprecated(
            "Please use newCredentialBuilder(String) instead",
            ReplaceWith("newCredentialBuilder(providerId).setIdToken(idToken).setAccessToken(accessToken)")
        )
        fun getCredential(providerId: String, idToken: String, accessToken: String): AuthCredential

        fun newBuilder(providerId: String, firebaseAuth: FirebaseAuth): Builder
        fun newBuilder(providerId: String): Builder
        fun newCredentialBuilder(providerId: String): CredentialsBuilder
    }

    class Builder {

        companion object

        fun build(): OAuthProvider
        fun addCustomParameter(paramKey: String, paramValue: String): Builder
        fun addCustomParameters(customParameters: Map<String, String>): Builder
        fun setScopes(scopes: List<String>): Builder

    }

    class CredentialsBuilder {

        companion object

        fun build(): AuthCredential
        fun setAccessToken(accessToken: String): CredentialsBuilder
        fun setIdToken(idToken: String): CredentialsBuilder
        fun setIdTokenWithRawNonce(idToken: String, rawNonce: String? = null): CredentialsBuilder
    }

}