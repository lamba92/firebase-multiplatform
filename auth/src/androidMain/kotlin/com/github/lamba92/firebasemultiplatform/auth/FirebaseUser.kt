package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.await
import com.github.lamba92.firebasemultiplatform.core.awaitUnit

actual class FirebaseUser(
    val delegate: PlatformSpecificFirebaseUser
) {

    actual val displayName: String?
        get() = delegate.displayName
    actual val email: String?
        get() = delegate.email
    actual val metadata: FirebaseUserMetadata?
        get() = delegate.metadata?.toMpp()
    actual val phoneNumber: String?
        get() = delegate.phoneNumber
    actual val photoUrl: String?
        get() = delegate.photoUrl?.toString()
    actual val providerData: List<FirebaseUserInfo>
        get() = delegate.providerData.map { it.toMpp() }
    actual val providerId: String
        get() = delegate.providerId
    actual val uid: String
        get() = delegate.uid
    actual val isAnonymous: Boolean
        get() = delegate.isAnonymous
    actual val isEmailVerified: Boolean
        get() = delegate.isEmailVerified

    actual suspend fun delete() =
        delegate.delete().awaitUnit()

    actual suspend fun getIdToken(forceRefresh: Boolean) =
        delegate.getIdToken(forceRefresh).await().toMpp()

    actual suspend fun linkWithCredentials(credential: AuthCredential) =
        delegate.linkWithCredential(credential.delegate).await().toMpp()

    actual suspend fun reauthenticate(credential: AuthCredential) =
        delegate.reauthenticate(credential.delegate).awaitUnit()

    actual suspend fun reauthenticateAndRetrieveData(credential: AuthCredential) =
        delegate.reauthenticateAndRetrieveData(credential.delegate).await().toMpp()

    actual suspend fun reload() =
        delegate.reload().awaitUnit()

    actual suspend fun sendEmailVerification() =
        delegate.sendEmailVerification().awaitUnit()

    actual suspend fun unlink(providerId: String) {
        delegate.unlink(providerId).await()
    }

    actual suspend fun updateEmail(email: String) =
        delegate.updateEmail(email).awaitUnit()

    actual suspend fun updatePassword(password: String) =
        delegate.updatePassword(password).awaitUnit()

    actual suspend fun updatePhoneNumber(phoneAuthCredential: PhoneAuthCredential) =
        delegate.updatePhoneNumber(phoneAuthCredential.delegate).awaitUnit()

    actual suspend fun updateProfile(userProfileChangeRequest: UserProfileChangeRequest) =
        delegate.updateProfile(userProfileChangeRequest.delegate).awaitUnit()

}