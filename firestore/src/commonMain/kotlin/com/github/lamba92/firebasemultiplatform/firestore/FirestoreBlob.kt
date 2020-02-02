package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreBlob : Comparable<FirestoreBlob> {

    val bytes: ByteArray

    companion object {
        fun fromBytes(bytes: ByteArray): FirestoreBlob
    }

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
