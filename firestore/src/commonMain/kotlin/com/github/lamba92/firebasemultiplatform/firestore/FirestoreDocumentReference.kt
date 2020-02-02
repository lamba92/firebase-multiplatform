package com.github.lamba92.firebasemultiplatform.firestore

import kotlinx.coroutines.flow.Flow

expect class FirestoreDocumentReference {

    val firestore: FirebaseFirestore
    val id: String
    val path: String

    fun snapshotChangesFlow(metadataChanges: FirestoreMetadataChanges? = null): Flow<FirestoreDocumentSnapshot>
    fun collection(collectionPath: String): FirestoreCollectionReference

    suspend fun get(source: Source? = null): FirestoreDocumentSnapshot
    suspend fun delete()
    suspend fun set(data: Any, options: FirestoreSetOptions? = null)
    suspend fun update(data: Map<String, Any?>)

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int


}
