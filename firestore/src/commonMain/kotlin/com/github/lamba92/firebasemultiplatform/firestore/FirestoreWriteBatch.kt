package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreWriteBatch {
    suspend fun commit()
    fun delete(documentReference: FirestoreDocumentReference)
    operator fun set(
        documentReference: FirestoreDocumentReference,
        options: FirestoreSetOptions? = null,
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
