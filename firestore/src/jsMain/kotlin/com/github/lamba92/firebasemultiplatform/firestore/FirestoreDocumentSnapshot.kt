package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.DocumentData
import firebase.firestore.DocumentSnapshot
import firebase.firestore.SnapshotOptions

actual class FirestoreDocumentSnapshot(val delegate: DocumentSnapshot<DocumentData>) {

    // TODO: DATES DAMN IT
    actual val exists: Boolean
        get() = delegate.exists
    actual val id: String
        get() = delegate.id
    actual val metadata: FirestoreSnapshotMetadata
        get() = delegate.metadata.toMpp()
    actual val reference: FirestoreDocumentReference
        get() = delegate.ref.toMpp()

    actual operator fun contains(fieldPath: FirestoreFieldPath) =
        delegate.get(fieldPath.delegate) != null

    actual operator fun contains(field: String) =
        delegate.get(field) != null

    actual inline operator fun <reified T> get(
        fieldPath: FirestoreFieldPath,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ): T? = delegate.get(fieldPath.delegate, object : SnapshotOptions {
        override var serverTimestamps: String =
            serverTimestampBehaviour?.asNative() ?: ServerTimestampBehaviour.NONE.asNative()
    }) as? T

    actual inline operator fun <reified T> get(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ): T? = delegate.get(field, object : SnapshotOptions {
        override var serverTimestamps: String =
            serverTimestampBehaviour?.asNative() ?: ServerTimestampBehaviour.NONE.asNative()
    }) as? T

    actual fun getBlob(field: String): FirestoreBlob? =
        get<ByteArray>(field)?.let { FirestoreBlob.fromBytes(it) }

    actual fun getBoolean(field: String): Boolean? =
        get<Boolean>(field)

    actual fun getData(serverTimestampBehaviour: ServerTimestampBehaviour?): Map<String, Any?>? =
        delegate.data(object : SnapshotOptions {
            override var serverTimestamps = serverTimestampBehaviour?.asNative()
                ?: ServerTimestampBehaviour.NONE.asNative()
        })

    actual fun getDouble(field: String): Double? =
        get<Double>(field)

    actual fun getLong(field: String): Long? =
        get<Long>(field)

    actual fun getGeoPoint(field: String): GeoPoint? =
        get<firebase.firestore.GeoPoint>(field)?.toMpp()

    actual fun getString(field: String): String? =
        get<String>(field)

    actual inline fun <reified T> toObject(serverTimestampBehaviour: ServerTimestampBehaviour?): T? =
        getData(serverTimestampBehaviour) as? T

    actual fun getTimestamp(field: String, serverTimestampBehaviour: ServerTimestampBehaviour?): Long? =
        get<Long>(field, serverTimestampBehaviour)

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreDocumentSnapshot -> delegate.isEqual(other.delegate)
        else -> false
    }

    actual override fun hashCode(): Int =
        getData()?.hashCode() ?: -1

    actual override fun toString(): String =
        "DocumentSnapshot{key=$id}, metadata=$metadata, doc=${getData()}"

    actual enum class ServerTimestampBehaviour {
        ESTIMATE, NONE, PREVIOUS
    }

}