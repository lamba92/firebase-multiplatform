package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.Transaction

actual class FirebaseTransaction(val delegate: Transaction) {
    actual fun delete(documentReference: FirebaseDocumentReference) {
    }

    actual operator fun get(documentReference: FirebaseDocumentReference): FirebaseDocumentSnapshot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual operator fun set(
        documentReference: FirebaseDocumentReference,
        setOptions: FirebaseSetOptions?,
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