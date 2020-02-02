package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreDocumentChange {

    val document: FirestoreDocumentSnapshot
    val newIndex: Int
    val oldIndex: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    enum class Type {
        ADDED, MODIFIED, REMOVED
    }
}
