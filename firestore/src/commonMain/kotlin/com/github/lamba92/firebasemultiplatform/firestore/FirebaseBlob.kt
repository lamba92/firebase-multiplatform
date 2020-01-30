package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseBlob : Comparable<FirebaseBlob> {

    val bytes: ByteArray

    companion object {
        fun fromBytes(bytes: ByteArray): FirebaseBlob
    }

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
