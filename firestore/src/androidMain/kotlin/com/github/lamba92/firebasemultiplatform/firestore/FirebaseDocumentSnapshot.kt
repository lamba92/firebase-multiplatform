package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.DocumentSnapshot

actual class FirebaseDocumentSnapshot(val delegate: DocumentSnapshot) {

    // TODO: DATES DAMN IT
    actual val exists: Boolean
        get() = delegate.exists()

    actual val id: String
        get() = delegate.id

    actual val metadata: FirebaseSnapshotMetadata
        get() = delegate.metadata.toMpp()

    actual val reference: FirebaseDocumentReference
        get() = delegate.reference.toMpp()

    actual operator fun contains(fieldPath: FieldPath) =
        fieldPath.delegate in delegate

    actual operator fun contains(field: String) =
        field in delegate

    actual inline operator fun <reified T> get(
        fieldPath: FieldPath,
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
        delegate.getGeoPoint(field).toMpp()

    actual fun getString(field: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun <T> toObject(serverTimestampBehaviour: ServerTimestampBehaviour?): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getTimestamp(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getDocumentReference(field: String): FirebaseDocumentReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun equals(other: Any?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun hashCode(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun toString(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual enum class ServerTimestampBehaviour {
        ESTIMATE, NONE, PREVIOUS
    }

}

private fun GeoPoint?.toMpp() =
    GeoP
