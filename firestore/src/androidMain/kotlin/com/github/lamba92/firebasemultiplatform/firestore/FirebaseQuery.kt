package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.await
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

actual class FirebaseQuery(val delegate: Query) {

    actual val firestore: FirebaseFirestore
        get() = delegate.firestore.toMpp()

    @ExperimentalCoroutinesApi
    actual fun snapshotsFlow(metadataChanges: FirebaseMetadataChanges?) = callbackFlow {
        val callback = EventListener<QuerySnapshot> { snapshot, exception ->
            snapshot?.let { offer(it.toMpp()) }
            exception?.let { close(it) }
        }
        val unsubscriber = metadataChanges?.let { delegate.addSnapshotListener(it, callback) }
            ?: delegate.addSnapshotListener(callback)

        awaitClose { unsubscriber.remove() }
    }

    actual fun endAt(snapshot: FirebaseDocumentSnapshot) =
        delegate.endAt(snapshot.delegate).toMpp()

    actual fun endAt(vararg fieldValues: Any) =
        delegate.endAt(*fieldValues.expelDelegates()).toMpp()

    actual fun startAt(snapshot: FirebaseDocumentSnapshot) =
        delegate.startAt(snapshot.delegate).toMpp()

    actual fun startAt(vararg fieldValues: Any) =
        delegate.startAt(*fieldValues.expelDelegates()).toMpp()

    actual fun endBefore(snapshot: FirebaseDocumentSnapshot) =
        delegate.endBefore(snapshot.delegate).toMpp()

    actual fun endBefore(vararg fieldValues: Any) =
        delegate.endBefore(*fieldValues.expelDelegates()).toMpp()

    actual fun startAfter(snapshot: FirebaseDocumentSnapshot) =
        delegate.startAfter(snapshot.delegate).toMpp()

    actual fun startAfter(vararg fieldValues: Any) =
        delegate.startAfter(*fieldValues.expelDelegates()).toMpp()

    actual fun limit(limit: Long) =
        delegate.limit(limit).toMpp()

    actual fun limitToLast(limit: Long) =
        delegate.limitToLast(limit).toMpp()

    actual fun orderBy(fieldPath: FieldPath, direction: Direction?) =
        direction?.asNative()?.let { delegate.orderBy(fieldPath.delegate, it).toMpp() }
            ?: delegate.orderBy(fieldPath.delegate).toMpp()

    actual fun orderBy(field: String) =
        delegate.orderBy(field).toMpp()

    actual fun whereArrayContainsAny(fieldPath: FieldPath, values: List<Any>) =
        delegate.whereArrayContainsAny(fieldPath.delegate, values).toMpp()

    actual fun whereArrayContainsAny(field: String, values: List<Any>) =
        delegate.whereArrayContainsAny(field, values).toMpp()

    actual fun whereEqualTo(fieldPath: FieldPath, value: Any) =
        delegate.whereEqualTo(fieldPath.delegate, value).toMpp()

    actual fun whereEqualTo(field: String, value: Any) =
        delegate.whereEqualTo(field, value).toMpp()

    actual fun whereGreaterThan(fieldPath: FieldPath, value: Any) =
        delegate.whereGreaterThan(fieldPath.delegate, value).toMpp()

    actual fun whereGreaterThan(field: String, value: Any) =
        delegate.whereGreaterThan(field, value).toMpp()

    actual fun whereGreaterThanOrEqualTo(fieldPath: FieldPath, value: Any) =
        delegate.whereGreaterThanOrEqualTo(fieldPath.delegate, value).toMpp()

    actual fun whereGreaterThanOrEqualTo(field: String, value: Any) =
        delegate.whereGreaterThanOrEqualTo(field, value).toMpp()

    actual fun whereLessThanOrEqualTo(fieldPath: FieldPath, value: Any) =
        delegate.whereLessThanOrEqualTo(fieldPath.delegate, value).toMpp()

    actual fun whereLessThanOrEqualTo(field: String, value: Any) =
        delegate.whereLessThanOrEqualTo(field, value).toMpp()

    actual fun whereLessThan(fieldPath: FieldPath, value: Any) =
        delegate.whereLessThan(fieldPath.delegate, value).toMpp()

    actual fun whereLessThan(field: String, value: Any) =
        delegate.whereLessThan(field, value).toMpp()

    actual fun whereIn(field: String, values: List<Any>) =
        delegate.whereIn(field, values).toMpp()

    actual fun whereIn(fieldPath: FieldPath, values: List<Any>) =
        delegate.whereIn(fieldPath.delegate, values).toMpp()

    actual suspend fun get(source: Source?) =
        source?.let { delegate.get(it).await().toMpp() }
            ?: delegate.get().await().toMpp()

    actual override fun equals(other: Any?) = when (other) {
        is FirebaseQuery -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual enum class Direction {
        ASCENDING, DESCENDING
    }

}