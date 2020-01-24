package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIROAuthProvider

actual class OAuthProvider(override val delegate: FIROAuthProvider) : FederatedAuthProvider(delegate) {

    actual val providerId: String?
        get() = delegate.providerID

    actual companion object {

        @Deprecated(
            "Please use newCredentialBuilder(String) instead",
            ReplaceWith("newCredentialBuilder(providerId).setIdToken(idToken).setAccessToken(accessToken)")
        )
        actual fun getCredential(providerId: String, idToken: String, accessToken: String) =
            FIROAuthProvider.credentialWithProviderID(
                providerID = providerId,
                IDToken = idToken,
                accessToken = accessToken
            )
                .toMpp()

        actual fun newBuilder(providerId: String) =
            Builder(FIROAuthProvider.providerWithProviderID(providerId))

        actual fun newCredentialBuilder(providerId: String) =
            CredentialsBuilder(providerId)

    }

    actual class Builder(val delegate: FIROAuthProvider) {

        actual companion object;

        actual fun build() =
            delegate.toMpp()

        actual fun setScopes(scopes: List<String>): Builder {
            delegate.scopes = scopes
            return this
        }

        actual fun setCustomParameters(customParameters: Map<String, String>): Builder {
            @Suppress("UNCHECKED_CAST")
            delegate.customParameters = customParameters as Map<Any?, *>
            return this
        }

    }

    actual class CredentialsBuilder(private val providerId: String) {

        private var accessToken: String? = null
        private var idToken: String? = null
        private var rawNonce: String? = null

        actual companion object;

        actual fun build() = when {
            accessToken != null && idToken == null && rawNonce == null ->
                FIROAuthProvider.credentialWithProviderID(providerId, accessToken!!).toMpp()
            idToken != null ->
                FIROAuthProvider.credentialWithProviderID(
                    providerID = providerId,
                    IDToken = idToken!!,
                    accessToken = accessToken,
                    rawNonce = rawNonce
                ).toMpp()
            else ->
                throw IllegalStateException("Either access token or id token must be set.")
        }

        actual fun setAccessToken(accessToken: String): CredentialsBuilder {
            this.accessToken = accessToken
            return this
        }

        actual fun setIdToken(idToken: String): CredentialsBuilder {
            this.idToken = idToken
            return this
        }

    }

}