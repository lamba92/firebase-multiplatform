@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.github.lamba92.firebasemultiplatform.storage

import android.net.Uri
import com.github.lamba92.firebasemultiplatform.core.await
import com.github.lamba92.firebasemultiplatform.core.awaitUnit
import kotlinx.io.core.Input
import java.io.InputStream

actual class StorageReference(
    val delegate: PlatformSpecificStorageReference
) : Comparable<StorageReference> {

    override fun compareTo(other: StorageReference) =
        delegate.compareTo(other.delegate)

    actual val activeDownloadTasks: List<DownloadTask>
        get() = delegate.activeDownloadTasks.map { it.toMpp() }

    actual val activeUploadTasks: List<UploadTask>
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

    actual suspend fun getBytes(maxDownloadSize: Long) =
        delegate.getBytes(maxDownloadSize).await()!!

    actual suspend fun downloadUrl() =
        delegate.downloadUrl.await().toString()

    actual fun getFile(uri: String) =
        delegate.getFile(Uri.parse(uri)).toMpp()

    actual fun getStream() =
        delegate.stream.toMpp()

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

    fun putFile(uri: Uri, metadata: StorageMetadata, existingUploadUri: Uri): UploadTask =
        delegate.putFile(uri, metadata.delegate, existingUploadUri).toMpp()

    fun putFile(uri: Uri, metadata: StorageMetadata): UploadTask =
        delegate.putFile(uri, metadata.delegate).toMpp()

    fun putFile(uri: Uri): UploadTask =
        delegate.putFile(uri).toMpp()

    actual fun putFile(uri: String, metadata: StorageMetadata, existingUploadUri: String): UploadTask =
        putFile(uri.toUri(), metadata, existingUploadUri.toUri())

    actual fun putFile(uri: String, metadata: StorageMetadata): UploadTask =
        putFile(uri.toUri(), metadata)

    actual fun putFile(uri: String): UploadTask =
        putFile(uri.toUri())

    fun putStream(stream: InputStream, metadata: StorageMetadata): UploadTask =
        delegate.putStream(stream, metadata.delegate).toMpp()

    fun putStream(stream: InputStream): UploadTask =
        delegate.putStream(stream).toMpp()

    actual fun putStream(stream: Input, metadata: StorageMetadata): UploadTask =
        putStream(stream.asStream(), metadata)

    actual fun putStream(stream: Input): UploadTask =
        putStream(stream.asStream())

    actual suspend fun updateMetadata(metadata: StorageMetadata) =
        delegate.updateMetadata(metadata.delegate).await().toMpp()

}