package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.SnapshotMetadata

actual class FirestoreSnapshotMetadata(val delegate: SnapshotMetadata) {

    actual val hasPendingWrites: Boolean
        get() = delegate.hasPendingWrites
    actual val isFromCache: Boolean
        get() = delegate.fromCache

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreSnapshotMetadata -> hasPendingWrites == other.hasPendingWrites
                && isFromCache == other.isFromCache
        else -> false
    }

    actual override fun hashCode(): Int {
        var hash = if (hasPendingWrites) 1 else 0
        hash = hash * 31 + if (isFromCache) 1 else 0
        return hash
    }

    actual override fun toString() =
        "FirestoreSnapshotMetadata(hasPendingWrites=$hasPendingWrites, isFromCache=$isFromCache)"

}