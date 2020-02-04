package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.DocumentData
import firebase.firestore.Query
import firebase.firestore.`T$30`
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.callbackFlow

actual class FirestoreQuery(val delegate: Query<DocumentData>) {

    actual val firestore: FirebaseFirestore
        get() = delegate.firestore.toMpp()

    @ExperimentalCoroutinesApi
    actual fun snapshotsFlow(metadataChanges: FirestoreMetadataChanges?) =
        callbackFlow<FirestoreQuerySnapshot> {
            val callbacks = object : `T$30`
            delegate.onSnapshot()
        }

    actual fun endAt(snapshot: FirestoreDocumentSnapshot): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun endAt(vararg fieldValues: Any): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun startAt(snapshot: FirestoreDocumentSnapshot): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun startAt(vararg fieldValues: Any): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun endBefore(snapshot: FirestoreDocumentSnapshot): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun endBefore(vararg fieldValues: Any): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun startAfter(snapshot: FirestoreDocumentSnapshot): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun startAfter(vararg fieldValues: Any): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun limit(limit: Long): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun limitToLast(limit: Long): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun orderBy(
        fieldPath: FirestoreFieldPath,
        direction: Direction?
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun orderBy(field: String): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereArrayContainsAny(
        fieldPath: FirestoreFieldPath,
        values: List<Any>
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereArrayContainsAny(
        field: String,
        values: List<Any>
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereEqualTo(
        fieldPath: FirestoreFieldPath,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereEqualTo(
        field: String,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereGreaterThan(
        fieldPath: FirestoreFieldPath,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereGreaterThan(
        field: String,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereGreaterThanOrEqualTo(
        fieldPath: FirestoreFieldPath,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereGreaterThanOrEqualTo(
        field: String,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereLessThanOrEqualTo(
        fieldPath: FirestoreFieldPath,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereLessThanOrEqualTo(
        field: String,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereLessThan(
        fieldPath: FirestoreFieldPath,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereLessThan(
        field: String,
        value: Any
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereIn(
        field: String,
        values: List<Any>
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun whereIn(
        fieldPath: FirestoreFieldPath,
        values: List<Any>
    ): FirestoreQuery {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun get(source: Source?): FirestoreQuerySnapshot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual override fun equals(other: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual override fun hashCode(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual enum class Direction {
        ASCENDING, DESCENDING
    }

}