package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreQuerySnapshot : Iterable<FirestoreDocumentSnapshot> {

    val documents: List<FirestoreDocumentSnapshot>
    val metadata: FirestoreSnapshotMetadata
    val query: FirestoreQuery

    fun getDocumentChanges(metadataChanges: FirestoreMetadataChanges? = null): List<FirestoreDocumentChange>

    inline fun <reified T> toObjects(
        serverTimestampBehaviour: FirestoreDocumentSnapshot.ServerTimestampBehaviour? = null
    ): List<T>

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}
