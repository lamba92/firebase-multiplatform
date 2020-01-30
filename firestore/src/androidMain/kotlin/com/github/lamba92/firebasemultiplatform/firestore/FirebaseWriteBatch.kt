package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.WriteBatch

actual class FirebaseWriteBatch(val delegate: WriteBatch) {
    actual suspend fun commit() {
    }

    actual fun delete(documentReference: FirebaseDocumentReference) {
    }

    actual operator fun set(
        documentReference: FirebaseDocumentReference,
        options: FirebaseSetOptions?,
        data: Any
    ) {
    }

    actual fun update(
        documentReference: FirebaseDocumentReference,
        data: Map<String, Any>
    ) {
    }

    actual fun update(
        documentReference: FirebaseDocumentReference,
        field: String,
        value: Any,
        vararg moreFieldsAndValues: Any
    ) {
    }

    actual fun update(
        documentReference: FirebaseDocumentReference,
        fieldPath: FieldPath,
        vararg moreFieldsAndValues: Any
    ) {
    }

}