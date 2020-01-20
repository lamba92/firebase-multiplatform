package com.github.lamba92.firebasemultiplatform.auth

import firebase.User

actual class FirebaseUser(val delegate: User) {
    actual val displayName: String?
        get() = TODO("Not yet implemented")
    actual val email: String?
        get() = TODO("Not yet implemented")
    actual val metadata: FirebaseUserMetadata?
        get() = TODO("Not yet implemented")
    actual val phoneNumber: String?
        get() = TODO("Not yet implemented")
    actual val photoUrl: String?
        get() = TODO("Not yet implemented")
    actual val providerData: List<UserInfo>
        get() = TODO("Not yet implemented")
    actual val providerId: String
        get() = TODO("Not yet implemented")
    actual val uid: String
        get() = TODO("Not yet implemented")
    actual val isAnonymous: Boolean
        get() = TODO("Not yet implemented")

    actual suspend fun delete() {
    }

    actual suspend fun getIdToken(forceRefresh: Boolean): GetTokenResults {
        TODO("Not yet implemented")
    }

    actual suspend fun linkWithCredentials(credential: AuthCredential): AuthResult {
        TODO("Not yet implemented")
    }

    actual suspend fun reauthenticate(credential: AuthCredential) {
    }

    actual suspend fun reauthenticateAndRetrieveData(credential: AuthCredential): AuthResult {
        TODO("Not yet implemented")
    }

    actual suspend fun reload() {
    }

    actual suspend fun sendEmailVerification() {
    }

    actual suspend fun unlink(provider: String) {
    }

    actual suspend fun updateEmail(email: String) {
    }

    actual suspend fun updatePassword(password: String) {
    }

    actual suspend fun updatePhoneNumber(phoneAuthCredential: PhoneAuthCredential) {
    }

    actual suspend fun updateProfile(userProfileChangeRequest: UserProfileChangeRequest) {
    }

}