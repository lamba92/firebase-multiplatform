package com.github.lamba92.firebasemultiplatform.firestore


actual class FirestoreDocumentChange(val delegate: com.google.firebase.firestore.DocumentChange) {

    actual val document: FirestoreDocumentSnapshot
        get() = delegate.document.toMpp()

    actual val newIndex: Int
        get() = delegate.newIndex

    actual val oldIndex: Int
        get() = delegate.oldIndex

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreDocumentChange -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual enum class Type {
        ADDED, MODIFIED, REMOVED
    }

}