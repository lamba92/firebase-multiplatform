package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.DocumentSnapshot

actual class FirestoreDocumentSnapshot(val delegate: DocumentSnapshot) {

    // TODO: DATES DAMN IT
    actual val exists: Boolean
        get() = delegate.exists()

    actual val id: String
        get() = delegate.id

    actual val metadata: FirestoreSnapshotMetadata
        get() = delegate.metadata.toMpp()

    actual val reference: FirestoreDocumentReference
        get() = delegate.reference.toMpp()

    actual operator fun contains(fieldPath: FirestoreFieldPath) =
        fieldPath.delegate in delegate

    actual operator fun contains(field: String) =
        field in delegate

    actual inline operator fun <reified T> get(
        fieldPath: FirestoreFieldPath,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ) =
        if (serverTimestampBehaviour != null)
            delegate.get(fieldPath.delegate, T::class.java, serverTimestampBehaviour.asNative())
        else
            delegate.get(fieldPath.delegate, T::class.java)


    actual inline operator fun <reified T> get(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ) =
        if (serverTimestampBehaviour != null)
            delegate.get(field, T::class.java, serverTimestampBehaviour.asNative())
        else
            delegate.get(field, T::class.java)

    actual fun getBlob(field: String) =
        delegate.getBlob(field)?.toMpp()

    actual fun getBoolean(field: String) =
        delegate.getBoolean(field)

    actual fun getData(serverTimestampBehaviour: ServerTimestampBehaviour?): Map<String, Any>? =
        if (serverTimestampBehaviour != null)
            delegate.getData(serverTimestampBehaviour.asNative())
        else
            delegate.data

    actual fun getDouble(field: String) =
        delegate.getDouble(field)

    actual fun getLong(field: String) =
        delegate.getLong(field)

    actual fun getGeoPoint(field: String) =
        delegate.getGeoPoint(field)?.toMpp()

    actual fun getString(field: String) =
        delegate.getString(field)

    actual inline fun <reified T> toObject(serverTimestampBehaviour: ServerTimestampBehaviour?) =
        serverTimestampBehaviour?.let { delegate.toObject(T::class.java, it.asNative()) }
            ?: delegate.toObject(T::class.java)

    actual fun getTimestamp(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ) = when (serverTimestampBehaviour) {
        null -> delegate.getTimestamp(field)
        else -> delegate.getTimestamp(field, serverTimestampBehaviour.asNative())
    }?.seconds

    fun getDocumentReference(field: String) =
        delegate.getDocumentReference(field)?.toMpp()

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreDocumentSnapshot -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual override fun toString() =
        delegate.toString()

    actual enum class ServerTimestampBehaviour {
        ESTIMATE, NONE, PREVIOUS
    }

}