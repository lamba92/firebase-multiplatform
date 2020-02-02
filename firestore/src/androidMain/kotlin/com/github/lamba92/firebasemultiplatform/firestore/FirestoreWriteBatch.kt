package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.awaitUnit
import com.google.firebase.firestore.WriteBatch

actual class FirestoreWriteBatch(val delegate: WriteBatch) {

    actual suspend fun commit() =
        delegate.commit().awaitUnit()

    actual fun delete(documentReference: FirestoreDocumentReference) {
        delegate.delete(documentReference.delegate)
    }

    actual operator fun set(
        documentReference: FirestoreDocumentReference,
        options: FirestoreSetOptions?,
        data: Any
    ) {
        options?.let { delegate.set(documentReference.delegate, data, it.delegate) }
            ?: delegate.set(documentReference.delegate, data)
    }

    actual fun update(
        documentReference: FirestoreDocumentReference,
        data: Map<String, Any>
    ) {
        delegate.update(documentReference.delegate, data)
    }

    actual fun update(
        documentReference: FirestoreDocumentReference,
        field: String,
        value: Any,
        vararg moreFieldsAndValues: Any
    ) {
        delegate.update(documentReference.delegate, field, value, *moreFieldsAndValues)
    }

    actual fun update(
        documentReference: FirestoreDocumentReference,
        fieldPath: FirestoreFieldPath,
        value: Any,
        vararg moreFieldsAndValues: Any
    ) {
        delegate.update(documentReference.delegate, fieldPath.delegate, value, *moreFieldsAndValues)
    }

}