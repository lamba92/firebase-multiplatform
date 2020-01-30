package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.SetOptions

actual class FirebaseSetOptions(val delegate: SetOptions) {

    actual companion object {

        actual fun merge() =
            SetOptions.merge().toMpp()

        actual fun mergeFields(fields: List<String>) =
            SetOptions.mergeFields(fields).toMpp()

        actual fun mergeFieldPaths(fields: List<FieldPath>) =
            SetOptions.mergeFieldPaths(fields.map { it.delegate }).toMpp()

    }

    actual override fun equals(other: Any?) = when (other) {
        is FirebaseSetOptions -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

}
