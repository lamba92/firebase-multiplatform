@file:JsModule("firebase")
@file:JsNonModule
@file:JsQualifier("firestore")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.firestore

import firebase.app.App
import org.khronos.webgl.Uint8Array
import kotlin.js.Date
import kotlin.js.Promise

external interface DocumentData

external interface UpdateData

external var CACHE_SIZE_UNLIMITED: Number

external interface Settings {
    var host: String?
        get() = definedExternally
        set(value) = definedExternally
    var ssl: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timestampsInSnapshots: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var cacheSizeBytes: Number?
        get() = definedExternally
        set(value) = definedExternally
    var experimentalForceLongPolling: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PersistenceSettings {
    var synchronizeTabs: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var experimentalTabSynchronization: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun setLogLevel(logLevel: String /* 'debug' */)

external interface FirestoreDataConverter<T> {
    fun toFirestore(modelObject: T): DocumentData
    fun fromFirestore(snapshot: QueryDocumentSnapshot<DocumentData>, options: SnapshotOptions): T
}

external interface `T$26` {
    var next: ((value: Unit) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var error: ((error: Error) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var complete: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$27` {
    var delete: () -> Promise<Unit>
}

open external class Firestore {
    open fun settings(settings: Settings)
    open fun enablePersistence(settings: PersistenceSettings? = definedExternally): Promise<Unit>
    open fun collection(collectionPath: String): CollectionReference<DocumentData>
    open fun doc(documentPath: String): DocumentReference<DocumentData>
    open fun collectionGroup(collectionId: String): Query<DocumentData>
    open fun <T> runTransaction(updateFunction: (transaction: Transaction) -> Promise<T>): Promise<T>
    open fun batch(): WriteBatch
    open var app: App
    open fun clearPersistence(): Promise<Unit>
    open fun enableNetwork(): Promise<Unit>
    open fun disableNetwork(): Promise<Unit>
    open fun waitForPendingWrites(): Promise<Unit>
    open fun onSnapshotsInSync(observer: `T$26`): () -> Unit
    open fun onSnapshotsInSync(onSync: () -> Unit): () -> Unit
    open fun terminate(): Promise<Unit>
    open var INTERNAL: `T$27`
}

open external class GeoPoint(latitude: Number, longitude: Number) {
    open var latitude: Number
    open var longitude: Number
    open fun isEqual(other: GeoPoint): Boolean
}

open external class Timestamp(seconds: Number, nanoseconds: Number) {
    open var seconds: Number
    open var nanoseconds: Number
    open fun toDate(): Date
    open fun toMillis(): Number
    open fun isEqual(other: Timestamp): Boolean

    companion object {
        fun now(): Timestamp
        fun fromDate(date: Date): Timestamp
        fun fromMillis(milliseconds: Number): Timestamp
    }
}

open external class Blob {
    open fun toBase64(): String
    open fun toUint8Array(): Uint8Array
    open fun isEqual(other: Blob): Boolean

    companion object {
        fun fromBase64String(base64: String): Blob
        fun fromUint8Array(array: Uint8Array): Blob
    }
}

open external class Transaction {
    open fun <T> get(documentRef: DocumentReference<T>): Promise<DocumentSnapshot<T>>
    open fun <T> set(documentRef: DocumentReference<T>, data: T, options: SetOptions? = definedExternally): Transaction
    open fun update(documentRef: DocumentReference<Any>, data: UpdateData): Transaction
    open fun update(
        documentRef: DocumentReference<Any>,
        field: String,
        value: Any,
        vararg moreFieldsAndValues: Any
    ): Transaction

    open fun update(
        documentRef: DocumentReference<Any>,
        field: FieldPath,
        value: Any,
        vararg moreFieldsAndValues: Any
    ): Transaction

    open fun delete(documentRef: DocumentReference<Any>): Transaction
}

open external class WriteBatch {
    open fun <T> set(documentRef: DocumentReference<T>, data: T, options: SetOptions? = definedExternally): WriteBatch
    open fun update(documentRef: DocumentReference<Any>, data: UpdateData): WriteBatch
    open fun update(
        documentRef: DocumentReference<Any>,
        field: String,
        value: Any,
        vararg moreFieldsAndValues: Any
    ): WriteBatch

    open fun update(
        documentRef: DocumentReference<Any>,
        field: FieldPath,
        value: Any,
        vararg moreFieldsAndValues: Any
    ): WriteBatch

    open fun delete(documentRef: DocumentReference<Any>): WriteBatch
    open fun commit(): Promise<Unit>
}

external interface SnapshotListenOptions {
    var includeMetadataChanges: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SetOptions {
    var merge: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var mergeFields: Array<dynamic /* String | FieldPath */>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GetOptions {
    var source: String /* 'default' | 'server' | 'cache' */
}

external interface `T$28`<T> {
    var next: ((snapshot: DocumentSnapshot<T>) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var error: ((error: FirestoreError) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var complete: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$29`<T> {
    var next: ((snapshot: DocumentSnapshot<T>) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var error: ((error: Error) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var complete: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

open external class DocumentReference<T> {
    open var id: String
    open var firestore: Firestore
    open var parent: CollectionReference<T>
    open var path: String
    open fun collection(collectionPath: String): CollectionReference<DocumentData>
    open fun isEqual(other: DocumentReference<T>): Boolean
    open fun set(data: Any, options: SetOptions? = definedExternally): Promise<Unit>
    open fun update(data: Map<String, Any?>): Promise<Unit>
    open fun update(field: String, value: Any, vararg moreFieldsAndValues: Any): Promise<Unit>
    open fun update(field: FieldPath, value: Any, vararg moreFieldsAndValues: Any): Promise<Unit>
    open fun delete(): Promise<Unit>
    open fun get(options: GetOptions? = definedExternally): Promise<DocumentSnapshot<T>>
    open fun <T> onSnapshot(observer: `T$28`<T>): () -> Unit
    open fun <T> onSnapshot(options: SnapshotListenOptions, observer: `T$29`<T>): () -> Unit
    open fun onSnapshot(
        onNext: (snapshot: DocumentSnapshot<T>) -> Unit,
        onError: ((error: Error) -> Unit)? = definedExternally,
        onCompletion: (() -> Unit)? = definedExternally
    ): () -> Unit

    open fun onSnapshot(
        options: SnapshotListenOptions,
        onNext: (snapshot: DocumentSnapshot<T>) -> Unit,
        onError: ((error: Error) -> Unit)? = definedExternally,
        onCompletion: (() -> Unit)? = definedExternally
    ): () -> Unit

    open fun <U> withConverter(converter: FirestoreDataConverter<U>): DocumentReference<U>
}

external interface SnapshotOptions {
    var serverTimestamps: String /* 'estimate' | 'previous' | 'none' */
}

external interface SnapshotMetadata {
    var hasPendingWrites: Boolean
    var fromCache: Boolean
    fun isEqual(other: SnapshotMetadata): Boolean
}

open external class DocumentSnapshot<T> {
    open var exists: Boolean
    open var ref: DocumentReference<T>
    open var id: String
    open var metadata: SnapshotMetadata
    open fun data(options: SnapshotOptions? = definedExternally): Map<String, Any?>?
    open fun get(fieldPath: String, options: SnapshotOptions? = definedExternally): Any?
    open fun get(fieldPath: FieldPath, options: SnapshotOptions? = definedExternally): Any?
    open fun isEqual(other: DocumentSnapshot<T>): Boolean
}

open external class QueryDocumentSnapshot<T> : DocumentSnapshot<T> {
    override fun data(options: SnapshotOptions?): T
}

external interface `T$30`<T> {
    var next: ((snapshot: QuerySnapshot<T>) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var error: ((error: Error) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var complete: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

open external class Query<T> {
    open var firestore: Firestore
    open fun where(
        fieldPath: String,
        opStr: String /* '<' | '<=' | '==' | '>=' | '>' | 'array-contains' | 'in' | 'array-contains-any' */,
        value: Any
    ): Query<T>

    open fun where(
        fieldPath: FieldPath,
        opStr: String /* '<' | '<=' | '==' | '>=' | '>' | 'array-contains' | 'in' | 'array-contains-any' */,
        value: Any
    ): Query<T>

    open fun orderBy(fieldPath: String, directionStr: String = definedExternally): Query<T>
    open fun orderBy(fieldPath: FieldPath, directionStr: String = definedExternally): Query<T>
    open fun limit(limit: Number): Query<T>
    open fun limitToLast(limit: Number): Query<T>
    open fun startAt(snapshot: DocumentSnapshot<Any>): Query<T>
    open fun startAt(vararg fieldValues: Any): Query<T>
    open fun startAfter(snapshot: DocumentSnapshot<Any>): Query<T>
    open fun startAfter(vararg fieldValues: Any): Query<T>
    open fun endBefore(snapshot: DocumentSnapshot<Any>): Query<T>
    open fun endBefore(vararg fieldValues: Any): Query<T>
    open fun endAt(snapshot: DocumentSnapshot<Any>): Query<T>
    open fun endAt(vararg fieldValues: Any): Query<T>
    open fun isEqual(other: Query<T>): Boolean
    open fun get(options: GetOptions? = definedExternally): Promise<QuerySnapshot<T>>
    open fun <T> onSnapshot(observer: `T$30`<T>): () -> Unit
    open fun <T> onSnapshot(options: SnapshotListenOptions, observer: `T$30`<T>): () -> Unit
    open fun onSnapshot(
        onNext: (snapshot: QuerySnapshot<T>) -> Unit,
        onError: ((error: Error) -> Unit)? = definedExternally,
        onCompletion: (() -> Unit)? = definedExternally
    ): () -> Unit

    open fun onSnapshot(
        options: SnapshotListenOptions,
        onNext: (snapshot: QuerySnapshot<T>) -> Unit,
        onError: ((error: Error) -> Unit)? = definedExternally,
        onCompletion: (() -> Unit)? = definedExternally
    ): () -> Unit

    open fun <U> withConverter(converter: FirestoreDataConverter<U>): Query<U>
    open fun orderBy(fieldPath: String): Query<T>
    open fun orderBy(fieldPath: FieldPath): Query<T>
}

open external class QuerySnapshot<T> {
    open var query: Query<T>
    open var metadata: SnapshotMetadata
    open var docs: Array<QueryDocumentSnapshot<T>>
    open var size: Number
    open var empty: Boolean
    open fun docChanges(options: SnapshotListenOptions? = definedExternally): Array<DocumentChange<T>>
    open fun forEach(callback: (result: QueryDocumentSnapshot<T>) -> Unit, thisArg: Any? = definedExternally)
    open fun isEqual(other: QuerySnapshot<T>): Boolean
}

external interface DocumentChange<T> {
    var type: String /* 'added' | 'removed' | 'modified' */
    var doc: QueryDocumentSnapshot<T>
    var oldIndex: Number
    var newIndex: Number
}

open external class CollectionReference<T> : Query<T> {
    open var id: String
    open var parent: DocumentReference<DocumentData>?
    open var path: String
    open fun doc(documentPath: String? = definedExternally): DocumentReference<T>
    open fun add(data: Any): Promise<DocumentReference<T>>
    open fun isEqual(other: CollectionReference<T>): Boolean
    override fun isEqual(other: Query<T>): Boolean
    override fun <U> withConverter(converter: FirestoreDataConverter<U>): CollectionReference<U>
}

open external class FieldValue {
    open fun isEqual(other: FieldValue): Boolean

    companion object {
        fun serverTimestamp(): FieldValue
        fun delete(): FieldValue
        fun arrayUnion(vararg elements: Any): FieldValue
        fun arrayRemove(vararg elements: Any): FieldValue
        fun increment(n: Number): FieldValue
    }
}

open external class FieldPath(vararg fieldNames: String) {
    open fun isEqual(other: FieldPath): Boolean

    companion object {
        fun documentId(): FieldPath
    }
}

external interface FirestoreError {
    var code: String /* 'cancelled' | 'unknown' | 'invalid-argument' | 'deadline-exceeded' | 'not-found' | 'already-exists' | 'permission-denied' | 'resource-exhausted' | 'failed-precondition' | 'aborted' | 'out-of-range' | 'unimplemented' | 'internal' | 'unavailable' | 'data-loss' | 'unauthenticated' */
    var message: String
    var name: String
    var stack: String?
        get() = definedExternally
        set(value) = definedExternally
}
