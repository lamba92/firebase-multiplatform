package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp

expect class FirebaseFirestore {

    val app: FirebaseApp
    companion object {

        val default: FirebaseFirestore

        fun setLoggingEnabled(loggingEnabled: Boolean)

        fun getInstance(app: FirebaseApp): FirebaseFirestore
    }

    suspend fun enableNetwork()

    suspend fun disableNetwork()
    suspend fun terminate()
    suspend fun clearPersistence()
    suspend fun awaitForPendingWrites()

    fun modifySettings(settings: FirebaseFirestoreSettings)

    fun collection(collectionPath: String): FirestoreCollectionReference
    fun collectionGroup(collectionId: String): FirestoreQuery
    fun document(documentPath: String): FirestoreDocumentReference

    fun batch(): FirestoreWriteBatch

    suspend fun <T> runTransaction(updateFunction: FirestoreTransaction.() -> T): T

}