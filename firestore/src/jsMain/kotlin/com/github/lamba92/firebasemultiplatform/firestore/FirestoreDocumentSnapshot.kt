package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.DocumentData
import firebase.firestore.DocumentSnapshot

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
        delegate.get()

    actual operator fun contains(field: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual inline operator fun <reified T> get(
        fieldPath: FirestoreFieldPath,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual inline operator fun <reified T> get(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getBlob(field: String): FirestoreBlob? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getBoolean(field: String): Boolean? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getData(serverTimestampBehaviour: ServerTimestampBehaviour?): Map<String, Any>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getDouble(field: String): Double? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getLong(field: String): Long? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getGeoPoint(field: String): GeoPoint? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getString(field: String): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual inline fun <reified T> toObject(serverTimestampBehaviour: ServerTimestampBehaviour?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getTimestamp(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour?
    ): Long? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getDocumentReference(field: String): FirestoreDocumentReference? {
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