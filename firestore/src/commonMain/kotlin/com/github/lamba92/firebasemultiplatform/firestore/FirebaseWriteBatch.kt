package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseWriteBatch {
    suspend fun commit()
    fun delete(documentReference: FirebaseDocumentReference)
    operator fun set(
        documentReference: FirebaseDocumentReference,
        options: FirebaseSetOptions? = null,
        data: Any
    )

    fun update(documentReference: FirebaseDocumentReference, data: Map<String, Any>)
    fun update(
        documentReference: FirebaseDocumentReference,
        field: String,
        value: Any,
        vararg moreFieldsAndValues: Any
    )

    fun update(
        documentReference: FirebaseDocumentReference,
        fieldPath: FieldPath,
        vararg moreFieldsAndValues: Any
    )
}
