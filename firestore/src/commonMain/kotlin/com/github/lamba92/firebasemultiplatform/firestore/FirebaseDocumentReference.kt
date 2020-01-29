package com.github.lamba92.firebasemultiplatform.firestore

import kotlinx.coroutines.flow.Flow

expect class FirebaseDocumentReference {

    val firestore: FirebaseFirestore
    val id: String
    val path: String

    fun snapshotChangesFlow(metadataChanges: FirebaseMetadataChanges? = null): Flow<FirebaseDocumentSnapshot>
    fun collection(collectionPath: String): FirebaseCollectionReference

    suspend fun get(source: Source? = null): FirebaseDocumentSnapshot
    suspend fun delete()
    suspend fun set(data: Any, options: FirebaseSetOptions? = null)
    suspend fun update(data: Map<String, Any?>)

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int


}
