package com.github.lamba92.firebasemultiplatform.firestore

import kotlinx.coroutines.flow.Flow

expect class FirebaseQuery {

    val firestore: FirebaseFirestore

    fun snapshotsFlow(metadataChanges: FirebaseMetadataChanges? = null): Flow<FirebaseQuerySnapshot>
    fun endAt(snapshot: FirebaseDocumentSnapshot): FirebaseQuery
    fun endAt(vararg fieldValues: Any): FirebaseQuery
    fun startAt(snapshot: FirebaseDocumentSnapshot): FirebaseQuery
    fun startAt(vararg fieldValues: Any): FirebaseQuery
    fun endBefore(snapshot: FirebaseDocumentSnapshot): FirebaseQuery
    fun endBefore(vararg fieldValues: Any): FirebaseQuery
    fun startAfter(snapshot: FirebaseDocumentSnapshot): FirebaseQuery
    fun startAfter(vararg fieldValues: Any): FirebaseQuery
    fun limit(limit: Long): FirebaseQuery
    fun limitToLast(limit: Long): FirebaseQuery
    fun orderBy(fieldPath: FieldPath, direction: Direction? = Direction.ASCENDING): FirebaseQuery
    fun orderBy(field: String): FirebaseQuery

    fun whereArrayContainsAny(fieldPath: FieldPath, values: List<Any>): FirebaseQuery
    fun whereArrayContainsAny(field: String, values: List<Any>): FirebaseQuery

    fun whereEqualTo(fieldPath: FieldPath, value: Any): FirebaseQuery
    fun whereEqualTo(field: String, value: Any): FirebaseQuery

    fun whereGreaterThan(fieldPath: FieldPath, value: Any): FirebaseQuery
    fun whereGreaterThan(field: String, value: Any): FirebaseQuery

    fun whereGreaterThanOrEqualTo(fieldPath: FieldPath, value: Any): FirebaseQuery
    fun whereGreaterThanOrEqualTo(field: String, value: Any): FirebaseQuery

    fun whereLessThanOrEqualTo(fieldPath: FieldPath, value: Any): FirebaseQuery
    fun whereLessThanOrEqualTo(field: String, value: Any): FirebaseQuery

    fun whereLessThan(fieldPath: FieldPath, value: Any): FirebaseQuery
    fun whereLessThan(field: String, value: Any): FirebaseQuery

    fun whereIn(field: String, values: List<Any>): FirebaseQuery
    fun whereIn(fieldPath: FieldPath, values: List<Any>): FirebaseQuery

    suspend fun get(source: Source? = null): FirebaseQuerySnapshot

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    enum class Direction {
        ASCENDING, DESCENDING
    }
}
