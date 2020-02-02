package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.SnapshotMetadata

actual class FirestoreSnapshotMetadata(val delegate: SnapshotMetadata) {
    actual val hasPendingWrites: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val isFromCache: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun equals(other: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun hashCode(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun toString(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}