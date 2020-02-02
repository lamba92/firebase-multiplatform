package com.github.lamba92.firebasemultiplatform.firestore

expect class FirestoreDocumentSnapshot {

    val exists: Boolean
    val id: String
    val metadata: FirestoreSnapshotMetadata
    val reference: FirestoreDocumentReference

    operator fun contains(fieldPath: FirestoreFieldPath): Boolean
    operator fun contains(field: String): Boolean

    inline operator fun <reified T> get(
        fieldPath: FirestoreFieldPath,
        serverTimestampBehaviour: ServerTimestampBehaviour? = null
    ): T?

    inline operator fun <reified T> get(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour? = null
    ): T?

    fun getBlob(field: String): FirestoreBlob?
    fun getBoolean(field: String): Boolean?
    fun getData(serverTimestampBehaviour: ServerTimestampBehaviour? = null): Map<String, Any>?
    fun getDouble(field: String): Double?
    fun getLong(field: String): Long?
    fun getGeoPoint(field: String): GeoPoint?
    fun getString(field: String): String?

    inline fun <reified T> toObject(serverTimestampBehaviour: ServerTimestampBehaviour? = null): T?

    fun getTimestamp(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour? = null
    ): Long?

    // TODO: DATES DAMN IT

    fun getDocumentReference(field: String): FirestoreDocumentReference?

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    enum class ServerTimestampBehaviour {
        ESTIMATE, NONE, PREVIOUS
    }
}
