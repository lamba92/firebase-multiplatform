package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.QuerySnapshot

actual class FirebaseQuerySnapshot(val delegate: QuerySnapshot) : Iterable<FirebaseDocumentSnapshot> {

    actual val documents: List<FirebaseDocumentSnapshot>
        get() = delegate.documents.map { it.toMpp() }

    actual val metadata: FirebaseSnapshotMetadata
        get() = delegate.metadata.toMpp()

    actual val query: FirebaseQuery
        get() = delegate.query.toMpp()

    actual fun getDocumentChanges(metadataChanges: FirebaseMetadataChanges?) =
        metadataChanges?.let { delegate.getDocumentChanges(it).map { it.toMpp() } }
            ?: delegate.documentChanges.map { it.toMpp() }

    actual inline fun <reified T> toObjects(serverTimestampBehaviour: FirebaseDocumentSnapshot.ServerTimestampBehaviour?): List<T> =
        serverTimestampBehaviour?.let { delegate.toObjects(T::class.java, it.asNative()) }
            ?: delegate.toObjects(T::class.java)

    actual override fun equals(other: Any?) = when (other) {
        is FirebaseQuerySnapshot -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    override fun iterator() =
        delegate.iterator()
            .asSequence()
            .map { it.toMpp() }
            .iterator()

}