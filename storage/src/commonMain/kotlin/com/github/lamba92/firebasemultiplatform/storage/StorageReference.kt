package com.github.lamba92.firebasemultiplatform.storage

import kotlinx.io.core.Input

expect class StorageReference : Comparator<StorageReference> {

    val activeDownloadTasks: List<DownloadTask>
    val activeUploadTasks: List<UploadTask>

    val bucket: String
    val name: String
    val parent: StorageReference
    val path: String
    val root: StorageReference
    val storage: FirebaseStorage

    fun child(path: String): StorageReference

    suspend fun delete()
    suspend fun getBytes(maxDownloadSize: Long): ByteArray
    suspend fun downloadUrl(): String

//    fun getFile(file: PlatformSpecificFile): DownloadTask
//    fun getFile(uri: PlatformSpecificUri): DownloadTask

    suspend fun getStream(): Input
    suspend fun getMetadata(): StorageMetadata

    suspend fun list(maxResults: Int, pageToken: String): ListResult
    suspend fun list(maxResults: Int): ListResult
    suspend fun listAll(): ListResult

    // TODO https://firebase.google.com/docs/reference/android/com/google/firebase/storage/StorageReference
}