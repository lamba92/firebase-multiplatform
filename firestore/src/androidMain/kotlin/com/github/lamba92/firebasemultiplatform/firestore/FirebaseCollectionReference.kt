package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.await
import com.google.firebase.firestore.CollectionReference

actual class FirebaseCollectionReference(val delegate: CollectionReference) {

    actual val parent: FirebaseDocumentReference?
        get() = delegate.parent?.toMpp()
    actual val id: String
        get() = delegate.id
    actual val path: String
        get() = delegate.path

    actual suspend fun add(data: Any) =
        delegate.add(data).await().toMpp()

    actual fun document(path: String?) =
        path?.let { delegate.document(it).toMpp() } ?: delegate.document().toMpp()


}