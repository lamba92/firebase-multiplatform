package com.github.lamba92.firebasemultiplatform.auth

import firebase.User
import kotlinx.coroutines.await

actual class FirebaseUser(val delegate: User) {

    actual val displayName: String?
        get() = delegate.displayName

    actual val email: String?
        get() = delegate.email

    actual val metadata: FirebaseUserMetadata?
        get() = delegate.metadata.toMpp()

    actual val phoneNumber: String?
        get() = delegate.phoneNumber

    actual val photoUrl: String?
        get() = delegate.photoURL

    actual val providerData: List<FirebaseUserInfo>
        get() = delegate.providerData.mapNotNull { it?.toMpp() }

    actual val providerId: String
        get() = delegate.providerId

    actual val uid: String
        get() = delegate.uid

    actual val isAnonymous: Boolean
        get() = delegate.isAnonymous

    actual val isEmailVerified: Boolean
        get() = delegate.emailVerified


    actual suspend fun delete() =
        delegate.delete().await()

    actual suspend fun getIdToken(forceRefresh: Boolean) =
        delegate.getIdTokenResult(forceRefresh).await().toMpp()

    actual suspend fun linkWithCredentials(credential: AuthCredential) =
        delegate.linkWithCredential(credential.delegate).await().toMpp()

    actual suspend fun reauthenticate(credential: AuthCredential) {
        delegate.reauthenticateWithCredential(credential.delegate).await()
    }

    actual suspend fun reauthenticateAndRetrieveData(credential: AuthCredential) =
        delegate.reauthenticateAndRetrieveDataWithCredential(credential.delegate).await().toMpp()

    actual suspend fun reload() =
        delegate.reload().await()

    actual suspend fun sendEmailVerification() =
        delegate.sendEmailVerification().await()

    actual suspend fun unlink(providerId: String) {
        delegate.unlink(this.providerId).await()
    }

    actual suspend fun updateEmail(email: String) =
        delegate.updateEmail(email).await()

    actual suspend fun updatePassword(password: String) =
        delegate.updatePassword(password).await()

    actual suspend fun updatePhoneNumber(phoneAuthCredential: PhoneAuthCredential) =
        delegate.updatePhoneNumber(phoneAuthCredential.delegate).await()

    actual suspend fun updateProfile(userProfileChangeRequest: UserProfileChangeRequest) =
        delegate.updateProfile(userProfileChangeRequest.delegate).await()

}