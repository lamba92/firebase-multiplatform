package com.github.lamba92.firebasemultiplatform.auth

actual class OAuthProvider(val delegate: firebase.auth.OAuthProvider) : FederatedAuthProvider() {

    actual val providerId: String?
        get() = delegate.providerId

    actual companion object {
        @Deprecated(
            "Please use newCredentialBuilder(String) instead",
            ReplaceWith("newCredentialBuilder(providerId).setIdToken(idToken).setAccessToken(accessToken)")
        )
        actual fun getCredential(providerId: String, idToken: String, accessToken: String) =
            newCredentialBuilder(providerId).setIdToken(idToken).setAccessToken(accessToken).build()

        actual fun newBuilder(providerId: String) =
            Builder(providerId)

        actual fun newCredentialBuilder(providerId: String) =
            CredentialsBuilder(providerId)

    }

    actual class Builder(private val providerId: String) {

        actual companion object;

        private var parameters = mutableMapOf<String, String>()
        private var scopes = emptyList<String>()

        actual fun build() = firebase.auth.OAuthProvider(providerId)
            .apply {
                scopes.forEach { addScope(it) }
                setCustomParameters(parameters)
            }
            .let { OAuthProvider(it) }

        actual fun setCustomParameters(customParameters: Map<String, String>): Builder {
            parameters = customParameters.toMutableMap()
            return this
        }

        actual fun setScopes(scopes: List<String>): Builder {
            this.scopes = scopes
            return this
        }

    }

    actual class CredentialsBuilder(private val providerId: String) {

        actual companion object;

        private val delegate = firebase.auth.OAuthCredential().apply {
            providerId = this@CredentialsBuilder.providerId
        }

        actual fun build() =
            delegate.toMpp()

        actual fun setAccessToken(accessToken: String): CredentialsBuilder {
            delegate.accessToken = accessToken
            return this
        }

        actual fun setIdToken(idToken: String): CredentialsBuilder {
            delegate.idToken = idToken
            return this
        }

    }

}