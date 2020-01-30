package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseSetOptions {

    companion object {

        fun merge(): FirebaseSetOptions
        fun mergeFields(fields: List<String>): FirebaseSetOptions
        fun mergeFieldPaths(fields: List<FieldPath>): FirebaseSetOptions

    }

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}
