package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreTransaction {
    fun delete(documentReference: FirestoreDocumentReference)
    operator fun get(documentReference: FirestoreDocumentReference): FirestoreDocumentSnapshot
    operator fun set(
        documentReference: FirestoreDocumentReference,
        setOptions: FirestoreSetOptions? = null,
        data: Any
    )

    fun update(documentReference: FirestoreDocumentReference, data: Map<String, Any>)
    fun update(
        documentReference: FirestoreDocumentReference,
        field: String,
        value: Any,
        vararg moreFieldsAndValues: Any
    )

    fun update(
        documentReference: FirestoreDocumentReference,
        fieldPath: FirestoreFieldPath,
        value: Any,
        vararg moreFieldsAndValues: Any
    )
}