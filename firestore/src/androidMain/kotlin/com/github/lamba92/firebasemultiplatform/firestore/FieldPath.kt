package com.github.lamba92.firebasemultiplatform.firestore

actual class FieldPath(val delegate: com.google.firebase.firestore.FieldPath) {

    actual companion object {
        actual val documentId: FieldPath
            get() = com.google.firebase.firestore.FieldPath.documentId().toMpp()

        actual fun of(vararg fieldNames: String) =
            com.google.firebase.firestore.FieldPath.of(*fieldNames).toMpp()

    }

    actual override fun equals(other: Any?) = when (other) {
        is FieldPath -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual override fun toString() =
        delegate.toString()

}