package com.github.lamba92.firebasemultiplatform.auth

actual class GetTokenResults(
    val delegate: PlatformSpecificGetTokenResults
) {

    actual val authTimestamp: Long
        get() = delegate.authTimestamp
    actual val claims: Map<String, Any>
        get() = delegate.claims
    actual val expirationTimestamp: Long
        get() = delegate.expirationTimestamp
    actual val issuedAtTimestamp: Long
        get() = delegate.issuedAtTimestamp
    actual val signInProvider: String?
        get() = delegate.signInProvider
    actual val token: String?
        get() = delegate.token

}