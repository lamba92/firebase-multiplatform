package com.github.lamba92.firebasemultiplatform.firestore

import kotlinx.coroutines.flow.Flow

expect class FirestoreQuery {

    val firestore: FirebaseFirestore

    fun snapshotsFlow(metadataChanges: FirestoreMetadataChanges? = null): Flow<FirestoreQuerySnapshot>
    fun endAt(snapshot: FirestoreDocumentSnapshot): FirestoreQuery
    fun endAt(vararg fieldValues: Any): FirestoreQuery
    fun startAt(snapshot: FirestoreDocumentSnapshot): FirestoreQuery
    fun startAt(vararg fieldValues: Any): FirestoreQuery
    fun endBefore(snapshot: FirestoreDocumentSnapshot): FirestoreQuery
    fun endBefore(vararg fieldValues: Any): FirestoreQuery
    fun startAfter(snapshot: FirestoreDocumentSnapshot): FirestoreQuery
    fun startAfter(vararg fieldValues: Any): FirestoreQuery
    fun limit(limit: Long): FirestoreQuery
    fun limitToLast(limit: Long): FirestoreQuery
    fun orderBy(fieldPath: FirestoreFieldPath, direction: Direction? = Direction.ASCENDING): FirestoreQuery
    fun orderBy(field: String): FirestoreQuery

    fun whereArrayContainsAny(fieldPath: FirestoreFieldPath, values: List<Any>): FirestoreQuery
    fun whereArrayContainsAny(field: String, values: List<Any>): FirestoreQuery

    fun whereEqualTo(fieldPath: FirestoreFieldPath, value: Any): FirestoreQuery
    fun whereEqualTo(field: String, value: Any): FirestoreQuery

    fun whereGreaterThan(fieldPath: FirestoreFieldPath, value: Any): FirestoreQuery
    fun whereGreaterThan(field: String, value: Any): FirestoreQuery

    fun whereGreaterThanOrEqualTo(fieldPath: FirestoreFieldPath, value: Any): FirestoreQuery
    fun whereGreaterThanOrEqualTo(field: String, value: Any): FirestoreQuery

    fun whereLessThanOrEqualTo(fieldPath: FirestoreFieldPath, value: Any): FirestoreQuery
    fun whereLessThanOrEqualTo(field: String, value: Any): FirestoreQuery

    fun whereLessThan(fieldPath: FirestoreFieldPath, value: Any): FirestoreQuery
    fun whereLessThan(field: String, value: Any): FirestoreQuery

    fun whereIn(field: String, values: List<Any>): FirestoreQuery
    fun whereIn(fieldPath: FirestoreFieldPath, values: List<Any>): FirestoreQuery

    suspend fun get(source: Source? = null): FirestoreQuerySnapshot

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    enum class Direction {
        ASCENDING, DESCENDING
    }
}
