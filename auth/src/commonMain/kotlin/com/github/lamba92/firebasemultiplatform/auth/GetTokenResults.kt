package com.github.lamba92.firebasemultiplatform.auth

expect class GetTokenResults(
    delegate: PlatformSpecificGetTokenResults
) {
    val delegate: PlatformSpecificGetTokenResults

    val authTimestamp: Long
    val claims: Map<String, Any>
    val expirationTimestamp: Long
    val issuedAtTimestamp: Long
    val signInProvider: String?
    val token: String?
}
