package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.Blob

actual class FirebaseBlob(val delegate: Blob) : Comparable<FirebaseBlob> {

    actual val bytes: ByteArray
        get() = delegate.toBytes()

    actual companion object {

        actual fun fromBytes(bytes: ByteArray) =
            Blob.fromBytes(bytes).toMpp()
    }

    actual override fun equals(other: Any?) = when (other) {
        is FirebaseBlob -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual override fun toString() =
        delegate.toString()

    override fun compareTo(other: FirebaseBlob) =
        delegate.compareTo(other.delegate)

}