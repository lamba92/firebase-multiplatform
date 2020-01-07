@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.resumeWithException
import com.github.lamba92.firebasemultiplatform.core.toMpp
import com.google.firebase.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.NSError
import kotlin.coroutines.resume

actual class FirebaseAuth(val delegate: FIRAuth) {

    actual val app: FirebaseApp
        get() = delegate.app!!.toMpp()

    actual val languageCode: String?
        get() = delegate.languageCode

    actual companion object {

        actual val default: FirebaseAuth
            get() = FIRAuth.auth().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            FIRAuth.authWithApp(app.delegate).toMpp()

    }

    @ExperimentalCoroutinesApi
    actual val authStateFlow by lazy {
        callbackFlow {
            val c = object : FIRAuthStateDidChangeListenerBlock {
                override fun invoke(p1: FIRAuth?, p2: FIRUser?) {
                    offer(p2 != null)
                }
            }
            val h = delegate.addAuthStateDidChangeListener(c)
            awaitClose { delegate.removeAuthStateDidChangeListener(h) }
        }
    }

    @ExperimentalCoroutinesApi
    actual val idTokenFlow by lazy {
        callbackFlow {
            val c = object : FIRIDTokenDidChangeListenerBlock {
                override fun invoke(p1: FIRAuth?, p2: FIRUser?) {
                    p2?.getIDTokenResultWithCompletion(object : FIRAuthTokenResultCallback {
                        override fun invoke(p1: FIRAuthTokenResult?, p2: NSError?) {
                            p1?.token?.let { offer(it) }
                        }

                    })
                }

            }
            val h = delegate.addIDTokenDidChangeListener(c)
            awaitClose { delegate.removeIDTokenDidChangeListener(h) }
        }
    }

    @ExperimentalCoroutinesApi
    actual suspend fun applyActionCode(code: String) = suspendCancellableCoroutine<Unit> { cont ->
        delegate.applyActionCode(code) { nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: cont.resume(Unit)
        }
    }

    actual suspend fun checkActionCode(code: String) = suspendCancellableCoroutine<ActionCodeResult> { cont ->
        delegate.checkActionCode(code) { actionCodeInfo, error ->
            error?.let { cont.resumeWithException(it) }
                ?: actionCodeInfo?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun confirmPasswordReset(code: String, password: String) =
        suspendCancellableCoroutine<Unit> { cont ->
            delegate.confirmPasswordResetWithCode(code, password) { error ->
                error?.let { cont.resumeWithException(it) }
                    ?: cont.resume(Unit)
            }
        }

    actual suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ) = suspendCancellableCoroutine<AuthResult> { cont ->
        delegate.createUserWithEmail(email, password) { authData, error ->
            error?.let { cont.resumeWithException(it) }
                ?: cont.resume(authData!!.toMpp())
        }
    }

    actual suspend fun fetchSignInMethodsForEmail(email: String) =
        suspendCancellableCoroutine<List<String>> { cont ->
            delegate.fetchSignInMethodsForEmail(email) { authList, error ->
                error?.let { cont.resumeWithException(it) }
                    ?: authList?.mapNotNull { it as? String }?.let { cont.resume(it) }
            }
        }

    actual suspend fun sendPasswordResetEmail(email: String) = suspendCancellableCoroutine<Unit> { cont ->
        delegate.sendPasswordResetWithEmail(email, object : FIRSendPasswordResetCallback {
            override fun invoke(p1: NSError?) {
                p1?.let { cont.resumeWithException(it) }
                    ?: cont.resume(Unit)
            }
        })
    }

    actual suspend fun signInAnonymously() = suspendCancellableCoroutine<AuthResult> { cont ->
        delegate.signInAnonymouslyWithCompletion { firAuthDataResult, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: firAuthDataResult?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun signInWithCredential(credential: AuthCredential) =
        suspendCancellableCoroutine<AuthResult> { cont ->
            delegate.signInWithCredential(credential.delegate) { authResult, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: authResult?.let { cont.resume(it.toMpp()) }
            }
        }

    actual suspend fun signInWithCustomToken(token: String) = suspendCancellableCoroutine<AuthResult> { cont ->
        delegate.signInWithCustomToken(token) { authResult, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: authResult?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ) = suspendCancellableCoroutine<AuthResult> { cont ->
        delegate.signInWithEmail(email, password = password) { authResult, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: authResult?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun signInWithEmailLink(
        email: String,
        link: String
    ) = suspendCancellableCoroutine<AuthResult> { cont ->
        delegate.signInWithEmail(email, link = link) { authResult, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: authResult?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun verifyPasswordResetCode(code: String) = suspendCancellableCoroutine<String> { cont ->
        delegate.verifyPasswordResetCode(code) { code, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: code?.let { cont.resume(it) }
        }
    }

    actual fun getCurrentUser() =
        delegate.currentUser()?.toMpp()

    actual fun isSignInWithEmailLink(link: String) =
        delegate.isSignInWithEmailLink(link)

    actual fun setLanguageCode(languageCode: String) =
        delegate.setLanguageCode(languageCode)

    actual fun signOut() {
        delegate.signOut(null)
    }

}