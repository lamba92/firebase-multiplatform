package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRUser
import com.google.firebase.FIRUserInfoProtocol
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.NSURL
import kotlin.coroutines.resume

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
        get() = delegate.providerID
    actual val uid: String
        get() = delegate.uid
    actual val isAnonymous: Boolean
        get() = delegate.anonymous

    @ExperimentalCoroutinesApi
    actual suspend fun delete() = suspendCancellableCoroutine<Unit> { cont ->
        delegate.deleteWithCompletion {
            it?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun getIdToken(forceRefresh: Boolean) = suspendCancellableCoroutine<GetTokenResults> { cont ->
        delegate.getIDTokenResultForcingRefresh(forceRefresh) { token, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: token?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun linkWithCredentials(credential: AuthCredential) =
        suspendCancellableCoroutine<AuthResult> { cont ->
            delegate.linkWithCredential(credential.delegate) { firAuthDataResult, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: firAuthDataResult?.let { cont.resume(it.toMpp()) }
            }
        }

    actual suspend fun reauthenticate(credential: AuthCredential) = suspendCancellableCoroutine<Unit> { cont ->
        delegate.reauthenticateWithCredential(credential.delegate) { firAuthDataResult, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: firAuthDataResult?.let { cont.resume(Unit) }
        }
    }

    actual suspend fun reauthenticateAndRetrieveData(credential: AuthCredential) =
        suspendCancellableCoroutine<AuthResult> { cont ->
            delegate.reauthenticateWithCredential(credential.delegate) { firAuthDataResult, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: firAuthDataResult?.let { cont.resume(it.toMpp()) }
            }
        }

    actual suspend fun reload() = suspendCancellableCoroutine<Unit> { cont ->
        delegate.reloadWithCompletion {
            it?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun sendEmailVerification() = suspendCancellableCoroutine<Unit> { cont ->
        delegate.sendEmailVerificationWithCompletion {
            it?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun unlink(provider: String) = suspendCancellableCoroutine<Unit> { cont ->
        delegate.unlinkFromProvider(provider) { _, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun updateEmail(email: String) = suspendCancellableCoroutine<Unit> { cont ->
        delegate.updateEmail(email) { nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun updatePassword(password: String) = suspendCancellableCoroutine<Unit> { cont ->
        delegate.updatePassword(password) { nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun updatePhoneNumber(phoneAuthCredential: PhoneAuthCredential) =
        suspendCancellableCoroutine<Unit> { cont ->
            delegate.updatePhoneNumberCredential(phoneAuthCredential.delegate) { nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: cont.resume(Unit)
            }
        }

    actual suspend fun updateProfile(userProfileChangeRequest: UserProfileChangeRequest) =
        suspendCancellableCoroutine<Unit> { cont ->
            delegate.profileChangeRequest()
                .apply {
                    photoURL = userProfileChangeRequest.photoUri?.let { NSURL.fileURLWithPath(it) }
                    displayName = userProfileChangeRequest.displayName
                }
                .commitChangesWithCompletion { nsError ->
                    nsError?.let { cont.resumeWithException(it) }
                        ?: cont.resume(Unit)
                }
        }

}