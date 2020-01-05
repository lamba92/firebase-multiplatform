package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRUser
import com.google.firebase.FIRUserInfoProtocol
import com.google.firebase.FIRUserMetadata

actual class FirebaseUser(val delegate: FIRUser) {

    actual val displayName: String?
        get() = delegate.displayName
    actual val email: String?
        get() = delegate.email
    actual val metadata: FirebaseUserMetadata?
        get() = delegate.metadata.toMpp()
    actual val phoneNumber: String?
        get() = delegate.phoneNumber
    actual val photoUrl: String?
        get() = delegate.phoneNumber
    actual val providerData: List<UserInfo>
        get() = delegate.providerData.mapNotNull { (it as? FIRUserInfoProtocol)?.toMpp() }
    actual val providerId: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val uid: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val isAnonymous: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual suspend fun delete() {
    }

    actual suspend fun getIdToken(forceRefresh: Boolean): GetTokenResults {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun linkWithCredentials(credential: AuthCredential): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun reauthenticate(credential: AuthCredential) {
    }

    actual suspend fun reauthenticateAndRetrieveData(credential: AuthCredential): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun reload() {
    }

    actual suspend fun sendEmailVerification() {
    }

    actual suspend fun unlink(provider: String): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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