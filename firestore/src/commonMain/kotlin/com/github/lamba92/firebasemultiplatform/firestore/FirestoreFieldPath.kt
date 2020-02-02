package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreFieldPath {

    companion object {
        val documentId: FirestoreFieldPath

        fun of(vararg fieldNames: String): FirestoreFieldPath
    }

    fun isSamePath(other: FirestoreFieldPath): Boolean

}
