package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRAuthTokenResult

actual class GetTokenResults(val delegate: FIRAuthTokenResult) {
    actual val authTimestamp: Long
        get() = delegate.authDate.timeIntervalSinceReferenceDate.toLong()
    actual val claims: Map<String, Any>
        get() = delegate.claims.mapNotNull { (k, v) ->
            k!!.toString() to v!!.toString()
        }.toMap()
    actual val expirationTimestamp: Long
        get() = delegate.expirationDate.timeIntervalSinceReferenceDate.toLong()
    actual val issuedAtTimestamp: Long
        get() = delegate.issuedAtDate.timeIntervalSinceReferenceDate.toLong()
    actual val signInProvider: String?
        get() = delegate.signInProvider
    actual val token: String?
        get() = delegate.token
}