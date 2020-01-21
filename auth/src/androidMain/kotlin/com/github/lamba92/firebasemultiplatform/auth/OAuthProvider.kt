@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.auth

actual class OAuthProvider(
    override val delegate: PlatformSpecificOAuthProvider
) : FederatedAuthProvider(delegate) {

    actual val providerId: String?
        get() = delegate.providerId

    actual companion object {

        @Suppress("DEPRECATION")
        @Deprecated(
            "Please use newCredentialBuilder(String) instead",
            ReplaceWith("newCredentialBuilder(providerId).setIdToken(idToken).setAccessToken(accessToken)")
        )
        actual fun getCredential(
            providerId: String,
            idToken: String,
            accessToken: String
        ) = PlatformSpecificOAuthProvider
            .getCredential(providerId, idToken, accessToken)
            .toMpp()

        fun newBuilder(providerId: String, firebaseAuth: FirebaseAuth) =
            PlatformSpecificOAuthProvider.newBuilder(providerId, firebaseAuth.delegate).toMpp()

        actual fun newBuilder(providerId: String) =
            PlatformSpecificOAuthProvider
                .newBuilder(providerId)
                .toMpp()

        actual fun newCredentialBuilder(providerId: String) =
            PlatformSpecificOAuthProvider
                .newCredentialBuilder(providerId)
                .toMpp()

    }

    actual class Builder(
        val delegate: PlatformSpecificOAuthProviderBuilder
    ) {

        actual companion object;

        actual fun build() =
            delegate.build().toMpp()

        actual fun setCustomParameters(customParameters: Map<String, String>): Builder {
            delegate.addCustomParameters(customParameters)
            return this
        }

        actual fun setScopes(scopes: List<String>): Builder {
            delegate.setScopes(scopes)
            return this
        }

    }

    actual class CredentialsBuilder(
        val delegate: PlatformSpecificOAuthProviderCredentialsBuilder
    ) {

        actual companion object;

        actual fun build() =
            delegate.build().toMpp()

        actual fun setAccessToken(accessToken: String): CredentialsBuilder {
            delegate.setAccessToken(accessToken)
            return this
        }

        actual fun setIdToken(idToken: String): CredentialsBuilder {
            delegate.setIdToken(idToken)
            return this
        }

        fun setIdTokenWithRawNonce(idToken: String, rawNonce: String?): CredentialsBuilder {
            delegate.setIdTokenWithRawNonce(idToken, rawNonce)
            return this
        }

    }

}

fun main() {

}