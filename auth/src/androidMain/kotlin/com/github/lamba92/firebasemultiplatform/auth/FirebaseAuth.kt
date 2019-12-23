package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.asUnit
import com.github.lamba92.firebasemultiplatform.await
import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.google.firebase.auth.FirebaseAuth.IdTokenListener
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

actual class FirebaseAuth actual constructor(
    actual val delegate: PlatformSpecificFirebaseAuth
) {

    actual companion object {

        actual val default: FirebaseAuth
            get() = PlatformSpecificFirebaseAuth.getInstance().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            PlatformSpecificFirebaseAuth.getInstance(app.delegate).toMpp()

    }

    actual val authStateFlow = flow {
        delegate.addAuthStateListener {
            runBlocking { emit(it.currentUser != null) }
        }
    }

    actual val idTokenFlow = flow {
        delegate.addIdTokenListener(IdTokenListener {
            runBlocking { it.currentUser?.getIdToken(false)?.await()?.token?.let { emit(it) } }
        })
    }

    actual suspend fun applyActionCode(code: String) =
        delegate.applyActionCode(code).await().asUnit()

    actual suspend fun checkActionCode(code: String) =
        delegate.checkActionCode(code).await().toMpp()

    actual suspend fun confirmPasswordReset(code: String, password: String) =
        delegate.confirmPasswordReset(code, password).await().asUnit()

    actual suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual val app: FirebaseApp
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val languageCode: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual suspend fun fetchSignInMethodsForEmail(email: String): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun sendPasswordResetEmail(email: String) {
    }

    actual suspend fun signInAnonymously(): AuthResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun signInWithCredential(credential: PlatformSpecificAuthCredential): AuthResult {
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