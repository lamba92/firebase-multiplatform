package com.github.lamba92.firebasemultiplatform.auth

fun PlatformSpecificActionCodeResult.toMpp() =
    ActionCodeResult(this)

fun PlatformSpecificAuthResult.toMpp() =
    AuthResult(this)

fun PlatformSpecificFirebaseUserMetadata.toMpp() =
    FirebaseUserMetadata(this)

fun PlatformSpecificUserInfo.toMpp() =
    FirebaseUserInfo(this)

fun PlatformSpecificAdditionalUserInfo.toMpp() =
    AdditionalUserInfo(this)

fun PlatformSpecificFirebaseAuth.toMpp() =
    FirebaseAuth(this)

fun PlatformSpecificFirebaseUser.toMpp() =
    FirebaseUser(this)

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