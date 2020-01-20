@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.toMpp
import firebase.auth.Auth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.await
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

actual class FirebaseAuth(val delegate: Auth) {

    actual val app: FirebaseApp
        get() = delegate.app.toMpp()

    actual val languageCode: String?
        get() = delegate.languageCode

    actual companion object {

        actual val default: FirebaseAuth
            get() = firebase.auth().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            firebase.auth(app.delegate).toMpp()
    }

    @ExperimentalCoroutinesApi
    actual val authStateFlow by lazy {
        callbackFlow {
            val u = delegate.onAuthStateChanged(
                nextOrObserver = {
                    offer(it != null)
                },
                error = {
                    close(it.asThrowable())
                }
            )
            awaitClose { u() }
        }
    }

    @ExperimentalCoroutinesApi
    actual val idTokenFlow by lazy {
        callbackFlow {
            val u = delegate.onIdTokenChanged(
                nextOrObserver = { user ->
                    user?.getIdToken(false)?.then { offer(it) }
                    Unit
                },
                error = {
                    close(it.asThrowable())
                }
            )
            awaitClose { u() }
        }
    }

    actual suspend fun applyActionCode(code: String) =
        delegate.applyActionCode(code).await()

    actual suspend fun checkActionCode(code: String) =
        delegate.checkActionCode(code).await().toMpp()

    actual suspend fun confirmPasswordReset(code: String, password: String) =
        delegate.confirmPasswordReset(code, password).await()

    actual suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        delegate.createUserWithEmailAndPassword(email, password).await().toMpp()

    actual suspend fun fetchSignInMethodsForEmail(email: String) =
        delegate.fetchSignInMethodsForEmail(email).await().toList()

    actual suspend fun sendPasswordResetEmail(email: String) =
        delegate.sendPasswordResetEmail(email).await()

    actual suspend fun signInAnonymously() =
        delegate.signInAnonymously().await().toMpp()

    actual suspend fun signInWithCredential(credential: AuthCredential) =
        delegate.signInWithCredential(credential.delegate).await().toMpp()

    actual suspend fun signInWithCustomToken(token: String) =
        delegate.signInWithCustomToken(token).await().toMpp()

    actual suspend fun signInWithEmailAndPassword(email: String, password: String) =
        delegate.signInWithEmailAndPassword(email, password).await().toMpp()

    actual suspend fun signInWithEmailLink(email: String, link: String) =
        delegate.signInWithEmailLink(email, link).await().toMpp()

    actual suspend fun verifyPasswordResetCode(code: String) =
        delegate.verifyPasswordResetCode(code).await()

    actual fun getCurrentUser() =
        delegate.currentUser?.toMpp()

    actual fun isSignInWithEmailLink(link: String) =
        delegate.isSignInWithEmailLink(link)

    actual fun setLanguageCode(languageCode: String) {
        delegate.languageCode = languageCode
    }

    actual suspend fun signOut() =
        delegate.signOut().await()

}
