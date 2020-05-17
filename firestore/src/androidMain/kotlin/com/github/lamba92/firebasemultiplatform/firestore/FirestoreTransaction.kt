package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.Transaction

actual class FirestoreTransaction(val delegate: Transaction) {

    actual fun delete(documentReference: FirestoreDocumentReference) {
        delegate.delete(documentReference.delegate)
    }

    actual operator fun get(documentReference: FirestoreDocumentReference) =
        delegate[documentReference.delegate].toMpp()

    actual operator fun set(
        documentReference: FirestoreDocumentReference,
        setOptions: FirestoreSetOptions?,
        data: Any
    ) {
        setOptions?.let { delegate.set(documentReference.delegate, data, it.delegate) }
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