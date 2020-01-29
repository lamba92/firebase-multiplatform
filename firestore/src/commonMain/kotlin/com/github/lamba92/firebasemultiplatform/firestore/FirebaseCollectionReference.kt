package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseCollectionReference {

    val document: FirebaseDocumentReference
    val parent: FirebaseDocumentReference
    val id: String
    val path: String

    suspend fun add(data: Any): FirebaseDocumentReference


}
