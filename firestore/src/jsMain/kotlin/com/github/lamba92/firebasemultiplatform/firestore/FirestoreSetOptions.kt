package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.SetOptions

actual class FirestoreSetOptions(val delegate: SetOptions) {

    actual companion object {

        actual fun merge() =
            object : SetOptions {
                override var merge: Boolean? = true
            }
                .toMpp()

        actual fun mergeFields(fields: List<String>) =
            object : SetOptions {
                override var mergeFields: Array<dynamic>? = fields.toTypedArray()
            }
                .toMpp()

        actual fun mergeFieldPaths(fields: List<FirestoreFieldPath>) =
            object : SetOptions {
                override var mergeFields: Array<dynamic>? = fields.map { it.delegate }.toTypedArray()
            }
                .toMpp()

    }

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreSetOptions -> delegate.merge == other.delegate.merge &&
                if (delegate.mergeFields != null && other.delegate.mergeFields != null)
                    delegate.mergeFields!!.contentEquals(other.delegate.mergeFields!!)
                else
                    false
        else -> false
    }

    actual override fun hashCode() =
        super.hashCode()

}

