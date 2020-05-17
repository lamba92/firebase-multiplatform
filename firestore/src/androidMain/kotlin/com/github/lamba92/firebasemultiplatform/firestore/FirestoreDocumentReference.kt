package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.await
import com.github.lamba92.firebasemultiplatform.core.awaitUnit
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

actual class FirestoreDocumentReference(val delegate: DocumentReference) {

    actual val firestore: FirebaseFirestore
        get() = delegate.firestore.toMpp()
    actual val id: String
        get() = delegate.id
    actual val path: String
        get() = delegate.path

    @ExperimentalCoroutinesApi
    actual fun snapshotChangesFlow(metadataChanges: FirestoreMetadataChanges?) =
        callbackFlow {
            val callback = EventListener<DocumentSnapshot> { snapshot, exception ->
                snapshot?.let { offer(it.toMpp()) }
                exception?.let { close(it) }
            }
            val unsubscriber = metadataChanges?.let { delegate.addSnapshotListener(it, callback) }
                ?: delegate.addSnapshotListener(callback)

            awaitClose { unsubscriber.remove() }
        }

    actual fun collection(collectionPath: String) =
        delegate.collection(collectionPath).toMpp()

    actual suspend fun get(source: Source?) =
        source?.let { delegate.get(it).await().toMpp() } ?: delegate.get().await().toMpp()

    actual suspend fun delete() =
        delegate.delete().awaitUnit()

    actual suspend fun set(data: Any, options: FirestoreSetOptions?) =
        options?.let { delegate.set(data, it.delegate) }?.awaitUnit()
            ?: delegate.set(data).awaitUnit()

    actual suspend fun update(data: Map<String, Any?>) =
        delegate.update(data).awaitUnit()

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreDocumentReference -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()


}