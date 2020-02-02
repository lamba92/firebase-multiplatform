package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.QuerySnapshot

actual class FirestoreQuerySnapshot(val delegate: QuerySnapshot) : Iterable<FirestoreDocumentSnapshot> {

    actual val documents: List<FirestoreDocumentSnapshot>
        get() = delegate.documents.map { it.toMpp() }

    actual val metadata: FirestoreSnapshotMetadata
        get() = delegate.metadata.toMpp()

    actual val query: FirestoreQuery
        get() = delegate.query.toMpp()

    actual fun getDocumentChanges(metadataChanges: FirestoreMetadataChanges?) =
        metadataChanges?.let { delegate.getDocumentChanges(it).map { it.toMpp() } }
            ?: delegate.documentChanges.map { it.toMpp() }

    actual inline fun <reified T> toObjects(serverTimestampBehaviour: FirestoreDocumentSnapshot.ServerTimestampBehaviour?): List<T> =
        serverTimestampBehaviour?.let { delegate.toObjects(T::class.java, it.asNative()) }
            ?: delegate.toObjects(T::class.java)

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreQuerySnapshot -> delegate == other.delegate
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