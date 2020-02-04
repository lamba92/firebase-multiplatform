package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.FieldPath

actual class FirestoreFieldPath(val delegate: FieldPath) {

    actual companion object {
        actual val documentId: FirestoreFieldPath
            get() = FieldPath.documentId().toMpp()

        actual fun of(vararg fieldNames: String) =
            FieldPath(*fieldNames).toMpp()

    }

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreFieldPath -> delegate.isEqual(other.delegate)
        else -> false
    }

    actual override fun hashCode() =
        super.hashCode()

    actual override fun toString() =
        delegate.toString()

}