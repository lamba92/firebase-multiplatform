package com.github.lamba92.firebasemultiplatform.auth

expect fun PlatformSpecificActionCodeResult.toMpp(): ActionCodeResult
expect fun PlatformSpecificFirebaseUserMetadata.toMpp(): FirebaseUserMetadata
expect fun PlatformSpecificUserInfo.toMpp(): UserInfo
expect fun PlatformSpecificAdditionalUserInfo.toMpp(): AdditionalUserInfo
expect fun PlatformSpecificAuthResult.toMpp(): AuthResult

fun PlatformSpecificFirebaseAuth.toMpp() =
    FirebaseAuth(this)

fun PlatformSpecificFirebaseUser.toMpp() =
    object : FirebaseUser(this) {}

fun PlatformSpecificUserProfileChangeRequest.toMpp() =
    UserProfileChangeRequest(this)

fun PlatformSpecificGetTokenResults.toMpp() =
    GetTokenResults(this)

fun PlatformSpecificPhoneAuthProvider.toMpp() =
    PhoneAuthProvider(this)

fun PlatformSpecificPhoneAuthCredential.toMpp() =
    PhoneAuthCredential(this)

fun PlatformSpecificAuthCredential.toMpp() =
    object : AuthCredential(this) {}

fun PlatformSpecificOAuthProviderBuilder.toMpp() =
    OAuthProvider.Builder(this)

fun PlatformSpecificOAuthProviderCredentialsBuilder.toMpp() =
    OAuthProvider.CredentialsBuilder(this)

fun PlatformSpecificOAuthProvider.toMpp() =
    OAuthProvider(this)


