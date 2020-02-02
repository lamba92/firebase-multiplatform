package com.github.lamba92.firebasemultiplatform.firestore

actual class FirestoreFieldPath(val delegate: com.google.firebase.firestore.FieldPath) {

    actual companion object {
        actual val documentId: FirestoreFieldPath
            get() = com.google.firebase.firestore.FieldPath.documentId().toMpp()

        actual fun of(vararg fieldNames: String) =
            com.google.firebase.firestore.FieldPath.of(*fieldNames).toMpp()

    }

    actual fun isSamePath(other: FirestoreFieldPath) =
        equals(other)

    override fun equals(other: Any?) = when (other) {
        is FirestoreFieldPath -> delegate == other.delegate
        else -> false
    }

    override fun hashCode() =
        delegate.hashCode()

    override fun toString() =
        delegate.toString()

}