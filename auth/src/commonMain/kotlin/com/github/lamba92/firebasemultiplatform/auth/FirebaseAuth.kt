package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import kotlinx.coroutines.flow.Flow

expect class FirebaseAuth(
    delegate: PlatformSpecificFirebaseAuth
) {
    val delegate: PlatformSpecificFirebaseAuth
    val app: FirebaseApp
    val languageCode: String

    companion object {
        val default: FirebaseAuth
        fun getInstance(app: FirebaseApp): FirebaseAuth
    }

    val authStateFlow: Flow<Boolean>
    val idTokenFlow: Flow<String>

    suspend fun applyActionCode(code: String)
    suspend fun checkActionCode(code: String): ActionCodeResult
    suspend fun confirmPasswordReset(code: String, password: String)
    suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult
    suspend fun fetchSignInMethodsForEmail(email: String): List<String>
    suspend fun sendPasswordResetEmail(email: String)
    suspend fun signInAnonymously(): AuthResult
    suspend fun signInWithCredential(credential: PlatformSpecificAuthCredential): AuthResult
    suspend fun signInWithCustomToken(token: String): AuthResult
    suspend fun signInWithEmailAndPassword(email: String, password: String): AuthResult
    suspend fun signInWithEmailLink(email: String, link: String): AuthResult
    suspend fun verifyPasswordResetCode(code: String): String

    fun getCurrentUser(): FirebaseUser?
    fun isSignInWithEmailLink(link: String): Boolean
    fun setLanguageCode(languageCode: String)
    fun signOut()

}