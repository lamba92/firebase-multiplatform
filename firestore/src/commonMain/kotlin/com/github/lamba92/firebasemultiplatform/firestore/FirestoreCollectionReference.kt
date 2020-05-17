package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreCollectionReference {

    fun document(path: String? = null): FirestoreDocumentReference
    val parent: FirestoreDocumentReference?
    val id: String
    val path: String

    suspend fun add(data: Any): FirestoreDocumentReference


}
