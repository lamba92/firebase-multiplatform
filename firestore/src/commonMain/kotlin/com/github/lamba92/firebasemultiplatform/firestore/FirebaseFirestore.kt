package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp

expect class FirebaseFirestore {

    val app: FirebaseApp
    var firestoreSettings: FirebaseFirestoreSettings

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

    fun collection(collectionPath: String): FirebaseCollectionReference
    fun collectionGroup(collectionId: String): FirebaseQuery
    fun document(documentPath: String): FirebaseDocumentReference

    fun batch(): FirebaseWriteBatch

    suspend fun <T> runTransaction(updateFunction: FirebaseTransaction.() -> T): T

}