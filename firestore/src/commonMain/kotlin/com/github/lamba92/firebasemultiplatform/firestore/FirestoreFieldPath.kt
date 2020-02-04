package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreFieldPath {

    companion object {
        val documentId: FirestoreFieldPath

        fun of(vararg fieldNames: String): FirestoreFieldPath
    }

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
