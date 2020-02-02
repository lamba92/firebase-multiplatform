package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

    actual suspend fun get(source: Source?): FirestoreDocumentSnapshot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun delete() {
    }

    actual suspend fun set(
        data: Any,
        options: FirestoreSetOptions?
    ) {
    }

    actual suspend fun update(data: Map<String, Any?>) {
    }

    actual fun equals(other: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun hashCode(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

