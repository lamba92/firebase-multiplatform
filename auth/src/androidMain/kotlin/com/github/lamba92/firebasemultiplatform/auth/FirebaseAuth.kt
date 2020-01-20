@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.await
import com.github.lamba92.firebasemultiplatform.core.awaitUnit
import com.github.lamba92.firebasemultiplatform.core.toMpp
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseAuth.IdTokenListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

actual class FirebaseAuth(
    val delegate: PlatformSpecificFirebaseAuth
) {

    actual companion object {

        actual val default: FirebaseAuth
            get() = PlatformSpecificFirebaseAuth.getInstance().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            PlatformSpecificFirebaseAuth.getInstance(app.delegate).toMpp()

    }

    @ExperimentalCoroutinesApi
    actual val authStateFlow by lazy {
        callbackFlow {
            val c = AuthStateListener { offer(it.currentUser != null) }
            delegate.addAuthStateListener(c)
            awaitClose { delegate.removeAuthStateListener(c) }
        }.flowOn(Dispatchers.Main)
    }

    @ExperimentalCoroutinesApi
    actual val idTokenFlow by lazy {
        callbackFlow {
            val c = IdTokenListener {
                it.currentUser?.getIdToken(false)
                    ?.addOnSuccessListener { it.token?.let { offer(it) } }
            }
            delegate.addIdTokenListener(c)
            awaitClose { delegate.removeIdTokenListener(c) }
        }
    }

    actual suspend fun applyActionCode(code: String) =
        delegate.applyActionCode(code).awaitUnit()

    actual suspend fun checkActionCode(code: String) =
        delegate.checkActionCode(code).await().toMpp()

    actual suspend fun confirmPasswordReset(code: String, password: String) =
        delegate.confirmPasswordReset(code, password).awaitUnit()

    actual suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        delegate.createUserWithEmailAndPassword(email, password).await().toMpp()

    actual val app by lazy { delegate.app.toMpp() }

    actual val languageCode
        get() = delegate.languageCode

    actual suspend fun fetchSignInMethodsForEmail(email: String): List<String> =
        delegate.fetchSignInMethodsForEmail(email).await().signInMethods ?: emptyList()

    actual suspend fun sendPasswordResetEmail(email: String) =
        delegate.sendPasswordResetEmail(email).awaitUnit()

    actual suspend fun signInAnonymously() =
        delegate.signInAnonymously().await().toMpp()

    actual suspend fun signInWithCredential(credential: AuthCredential) =
        delegate.signInWithCredential(credential.delegate).await().toMpp()

    actual suspend fun signInWithCustomToken(token: String) =
        delegate.signInWithCustomToken(token).await().toMpp()

    actual suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ) = delegate.signInWithEmailAndPassword(email, password).await().toMpp()

    actual suspend fun signInWithEmailLink(
        email: String,
        link: String
    ) = delegate.signInWithEmailLink(email, link).await().toMpp()

    actual suspend fun verifyPasswordResetCode(code: String) =
        delegate.verifyPasswordResetCode(code).await()!!

    actual fun getCurrentUser() =
        delegate.currentUser?.toMpp()

    actual fun isSignInWithEmailLink(link: String) =
        delegate.isSignInWithEmailLink(link)

    actual fun setLanguageCode(languageCode: String) =
        delegate.setLanguageCode(languageCode)

    actual suspend fun signOut() =
        withContext(Dispatchers.IO) { delegate.signOut() }

}