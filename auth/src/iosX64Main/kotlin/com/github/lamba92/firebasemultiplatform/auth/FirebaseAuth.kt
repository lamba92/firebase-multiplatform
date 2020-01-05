package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.toMpp
import com.google.firebase.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual class FirebaseAuth(
    val delegate: FIRAuth
) {
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
        delegate.applyActionCode(code, object : FIRApplyActionCodeCallback {
            override fun invoke(p1: NSError?) {
                p1.let { cont.resumeWithException(it) }
                    ?: cont.resume(Unit)
            }
        })
    }

    actual suspend fun checkActionCode(code: String) = suspendCancellableCoroutine<ActionCodeResult> { cont ->
        delegate.checkActionCode(code, object : FIRCheckActionCodeCallBack {
            override fun invoke(p1: FIRActionCodeInfo?, p2: NSError?) {
                p2.let { cont.resumeWithException(it) }
                    ?: cont.resume(p1!!.toMpp())
            }
        })
    }

    actual suspend fun confirmPasswordReset(code: String, password: String) =
        suspendCancellableCoroutine<Unit> { cont ->
            delegate.confirmPasswordResetWithCode(code, password, object : FIRConfirmPasswordResetCallback {
                override fun invoke(p1: NSError?) {
                    p1.let { cont.resumeWithException(it) }
                        ?: cont.resume(Unit)
                }
            })
        }

    actual suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ) = suspendCancellableCoroutine<AuthResult> { cont ->
        delegate.createUserWithEmail(email, password, object : FIRAuthDataResultCallback {
            override fun invoke(p1: FIRAuthDataResult?, p2: NSError?) {
                p2.let { cont.resumeWithException(it) }
                    ?: cont.resume(p1!!.toMpp())
            }
        })
    }

    actual suspend fun fetchSignInMethodsForEmail(email: String): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun sendPasswordResetEmail(email: String) {
    }

    actual suspend fun signInAnonymously(): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun signInWithCredential(credential: AuthCredential): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun signInWithCustomToken(token: String): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun signInWithEmailLink(
        email: String,
        link: String
    ): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun verifyPasswordResetCode(code: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getCurrentUser(): FirebaseUser? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun isSignInWithEmailLink(link: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun setLanguageCode(languageCode: String) {
    }

    actual fun signOut() {
    }

}