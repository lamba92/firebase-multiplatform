package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.SnapshotMetadata

actual class FirebaseSnapshotMetadata(val delegate: SnapshotMetadata) {

    actual val hasPendingWrites: Boolean
        get() = delegate.hasPendingWrites()

    actual val isFromCache: Boolean
        get() = delegate.isFromCache

    actual override fun equals(other: Any?) = when (other) {
        is FirebaseSnapshotMetadata -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual override fun toString() =
        delegate.toString()

}