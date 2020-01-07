@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.await
import com.github.lamba92.firebasemultiplatform.core.awaitUnit
import java.io.InputStream

actual class StorageReference(
    val delegate: PlatformSpecificStorageReference
) : Comparable<StorageReference> {

    override fun compareTo(other: StorageReference) =
        delegate.compareTo(other.delegate)

    val activeDownloadTasks: List<DownloadTask>
        get() = delegate.activeDownloadTasks.map { it.toMpp() }

    val activeUploadTasks: List<UploadTask>
        get() = delegate.activeUploadTasks.map { it.toMpp() }

    actual val bucket: String
        get() = delegate.bucket

    actual val name: String
        get() = delegate.name

    actual val parent: StorageReference?
        get() = delegate.parent?.toMpp()

    actual val path: String
        get() = delegate.path

    actual val root: StorageReference
        get() = delegate.root.toMpp()

    actual val storage: FirebaseStorage
        get() = delegate.storage.toMpp()

    actual fun child(pathString: String) =
        delegate.child(pathString).toMpp()

    actual suspend fun delete() =
        delegate.delete().awaitUnit()

    actual suspend fun downloadUrl() =
        delegate.downloadUrl.await().toString()

    actual suspend fun getMetadata() =
        delegate.metadata.await().toMpp()

    actual suspend fun list(maxResults: Int, pageToken: String) =
        delegate.list(maxResults, pageToken).await().toMpp()

    actual suspend fun list(maxResults: Int) =
        delegate.list(maxResults).await().toMpp()

    actual suspend fun listAll() =
        delegate.listAll().await().toMpp()

    actual fun putBytes(bytes: ByteArray, metadata: StorageMetadata) =
        delegate.putBytes(bytes, metadata.delegate).toMpp()

    actual fun putBytes(bytes: ByteArray) =
        delegate.putBytes(bytes).toMpp()

    fun putStream(stream: InputStream, metadata: StorageMetadata): UploadTask =
        delegate.putStream(stream, metadata.delegate).toMpp()

    fun putStream(stream: InputStream): UploadTask =
        delegate.putStream(stream).toMpp()

    actual suspend fun updateMetadata(metadata: StorageMetadata) =
        delegate.updateMetadata(metadata.delegate).await().toMpp()

}