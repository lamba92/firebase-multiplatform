package com.github.lamba92.firebasemultiplatform.firestore

expect class FieldPath {

    companion object {
        val documentId: FieldPath

        fun of(vararg fieldNames: String): FieldPath
    }

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
