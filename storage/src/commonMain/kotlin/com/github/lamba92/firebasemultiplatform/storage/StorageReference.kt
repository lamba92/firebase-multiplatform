package com.github.lamba92.firebasemultiplatform.storage

expect class StorageReference : Comparable<StorageReference> {

    val activeDownloadTasks: List<DownloadTask>
    val activeUploadTasks: List<UploadTask>

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

    suspend fun list(maxResults: Int, pageToken: String): ListResult
    suspend fun list(maxResults: Int): ListResult
    suspend fun listAll(): ListResult

    fun putBytes(bytes: ByteArray, metadata: StorageMetadata): UploadTask
    fun putBytes(bytes: ByteArray): UploadTask

    override fun toString(): String

    suspend fun updateMetadata(metadata: StorageMetadata): StorageMetadata

}