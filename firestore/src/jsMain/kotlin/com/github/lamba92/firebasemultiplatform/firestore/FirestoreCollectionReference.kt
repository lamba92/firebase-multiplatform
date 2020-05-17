package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.CollectionReference
import firebase.firestore.DocumentData
import kotlinx.coroutines.await

actual class FirestoreCollectionReference(val delegate: CollectionReference<DocumentData>) {

    actual fun document(path: String?) =
        delegate.doc(path).toMpp()

    actual val parent: FirestoreDocumentReference?
        get() = delegate.parent?.toMpp()
    actual val id: String
        get() = delegate.id
    actual val path: String
        get() = delegate.path

    actual suspend fun add(data: Any) =
        delegate.add(data).await().toMpp()


}