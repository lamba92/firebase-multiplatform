package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.await
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

actual class FirestoreDocumentReference(val delegate: DocumentReference<DocumentData>) {

    actual val firestore: FirebaseFirestore
        get() = delegate.firestore.toMpp()
    actual val id: String
        get() = delegate.id
    actual val path: String
        get() = delegate.path

    @ExperimentalCoroutinesApi
    actual fun snapshotChangesFlow(metadataChanges: FirestoreMetadataChanges?) =
        callbackFlow<FirestoreDocumentSnapshot> {
            val callback: (DocumentSnapshot<DocumentData>) -> Unit = { snapshot ->
                offer(snapshot.toMpp())
            }
            val errorCallback: (Error) -> Unit = { error ->
                close(error)
            }
            val competitionCallback: () -> Unit = {
                close()
            }

            val unsubscriber = metadataChanges?.let {
                delegate.onSnapshot(
                    object : SnapshotListenOptions {
                        override var includeMetadataChanges: Boolean? = when (it) {
                            FirestoreMetadataChanges.INCLUDE -> true
                            FirestoreMetadataChanges.EXCLUDE -> false
                        }
                    }, callback, errorCallback, competitionCallback
                )
            } ?: delegate.onSnapshot(callback, errorCallback, competitionCallback)

            awaitClose(unsubscriber)

        }

    actual fun collection(collectionPath: String) =
        delegate.collection(collectionPath).toMpp()

    actual suspend fun get(source: Source?) =
        delegate.get(object : GetOptions {
            override var source = source?.asNative()
                ?: Source.SERVER.asNative()
        }).await().toMpp()

    actual suspend fun delete() =
        delegate.delete().await()

    actual suspend fun set(data: Any, options: FirestoreSetOptions?) =
        delegate.set(data, options?.delegate).await()

    actual suspend fun update(data: Map<String, Any?>) =
        delegate.update(data).await()

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreDocumentReference -> delegate.isEqual(other.delegate)
        else -> false
    }

    actual override fun hashCode() =
        super.hashCode()

}