package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseTransaction {
    fun delete(documentReference: FirebaseDocumentReference)
    operator fun get(documentReference: FirebaseDocumentReference): FirebaseDocumentSnapshot
    operator fun set(
        documentReference: FirebaseDocumentReference,
        setOptions: FirebaseSetOptions? = null,
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