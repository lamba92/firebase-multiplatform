package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseDocumentSnapshot {

    val exists: Boolean
    val id: String
    val metadata: FirebaseSnapshotMetadata
    val reference: FirebaseDocumentReference

    operator fun contains(fieldPath: FieldPath): Boolean
    operator fun contains(field: String): Boolean

    inline operator fun <reified T> get(
        fieldPath: FieldPath,
        serverTimestampBehaviour: ServerTimestampBehaviour? = null
    ): T?

    inline operator fun <reified T> get(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour? = null
    ): T?

    fun getBlob(field: String): FirebaseBlob?
    fun getBoolean(field: String): Boolean?
    fun getData(serverTimestampBehaviour: ServerTimestampBehaviour? = null): Map<String, Any>?
    fun getDouble(field: String): Double?
    fun getLong(field: String): Long?
    fun getGeoPoint(field: String): GeoPoint?
    fun getString(field: String): String?

    fun <T> toObject(serverTimestampBehaviour: ServerTimestampBehaviour? = null): T

    fun getTimestamp(
        field: String,
        serverTimestampBehaviour: ServerTimestampBehaviour? = null
    ): Long

    // TODO: DATES DAMN IT

    fun getDocumentReference(field: String): FirebaseDocumentReference

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    enum class ServerTimestampBehaviour {
        ESTIMATE, NONE, PREVIOUS
    }
}
