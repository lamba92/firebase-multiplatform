package com.github.lamba92.firebasemultiplatform.storage

expect class StorageReference : Comparable<StorageReference> {

    val bucket: String
    val name: String
    val parent: StorageReference?
    val path: String
    val root: StorageReference
    val storage: FirebaseStorage

    fun child(pathString: String): StorageReference

    suspend fun delete()
    suspend fun downloadUrl(): String

    suspend fun getMetadata(): StorageMetadata

    suspend fun list(maxResults: Int, pageToken: String): StorageListResult
    suspend fun list(maxResults: Int): StorageListResult
    suspend fun listAll(): StorageListResult

    fun putBytes(bytes: ByteArray, metadata: StorageMetadata): UploadTask
    fun putBytes(bytes: ByteArray): UploadTask

    override fun toString(): String

    suspend fun updateMetadata(metadata: StorageMetadata): StorageMetadata

}