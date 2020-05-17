package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreSnapshotMetadata {

    val hasPendingWrites: Boolean
    val isFromCache: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
