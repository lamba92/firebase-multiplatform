package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseQuerySnapshot : Iterable<FirebaseDocumentSnapshot> {

    val documents: List<FirebaseDocumentSnapshot>
    val metadata: FirebaseSnapshotMetadata
    val query: FirebaseQuery

    fun getDocumentChanges(metadataChanges: FirebaseMetadataChanges? = null): List<DocumentChange>

    inline fun <reified T> toObjects(
        serverTimestampBehaviour: FirebaseDocumentSnapshot.ServerTimestampBehaviour? = null
    ): List<T>

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}
