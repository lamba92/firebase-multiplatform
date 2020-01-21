package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.IdTokenResult

actual class GetTokenResults(val delegate: IdTokenResult) {

    actual val authTimestamp: Long
        get() = delegate.authTime.toLong()
    actual val claims: Map<String, Any>
        get() = PrimitiveHashMap<Any>(delegate.claims)
    actual val expirationTimestamp: Long
        get() = delegate.expirationTime.toLong()
    actual val issuedAtTimestamp: Long
        get() = delegate.issuedAtTime.toLong()
    actual val signInProvider: String?
        get() = delegate.signInProvider
    actual val token: String?
        get() = delegate.token.takeIf { !it.isBlank() }
}