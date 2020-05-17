package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreSetOptions {

    companion object {

        fun merge(): FirestoreSetOptions
        fun mergeFields(fields: List<String>): FirestoreSetOptions
        fun mergeFieldPaths(fields: List<FirestoreFieldPath>): FirestoreSetOptions

    }

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}
