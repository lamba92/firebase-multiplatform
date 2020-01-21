package com.github.lamba92.firebasemultiplatform.storage

import firebase.storage.ListOptions
import firebase.storage.Reference
import kotlinx.coroutines.await
import org.khronos.webgl.Uint8Array

actual class StorageReference(val delegate: Reference) : Comparable<StorageReference> {

    actual val bucket: String
        get() = delegate.bucket
    actual val name: String
        get() = delegate.name
    actual val parent: StorageReference?
        get() = delegate.parent?.toMpp()
    actual val path: String
        get() = delegate.fullPath
    actual val root: StorageReference
        get() = delegate.root.toMpp()
    actual val storage: FirebaseStorage
        get() = delegate.storage.toMpp()

    actual fun child(pathString: String) =
        delegate.child(pathString).toMpp()

    actual suspend fun delete() {
        delegate.delete().await()
    }

    actual suspend fun downloadUrl() =
        delegate.getDownloadURL().await()

    actual suspend fun getMetadata() =
        delegate.getMetadata().await().toMpp()

    actual suspend fun list(maxResults: Int, pageToken: String) =
        delegate.list(object : ListOptions {
                override var maxResults: Number? = maxResults
                override var pageToken: String? = pageToken
            })
            .await()
            .toMpp()

    actual suspend fun list(maxResults: Int) =
        delegate.list(object : ListOptions {
                override var maxResults: Number? = maxResults
            })
            .await()
            .toMpp()

    actual suspend fun listAll() =
        delegate.listAll().await().toMpp()

    actual fun putBytes(bytes: ByteArray, metadata: StorageMetadata) =
        delegate.put(Uint8Array(bytes.toTypedArray()), metadata.delegate).toMpp()


    actual fun putBytes(bytes: ByteArray) =
        delegate.put(Uint8Array(bytes.toTypedArray())).toMpp()

    actual override fun toString() =
        delegate.toString()

    actual suspend fun updateMetadata(metadata: StorageMetadata) =
        delegate.updateMetadata(metadata.delegate).await().toMpp()

    override fun compareTo(other: StorageReference) =
        delegate.fullPath.compareTo(other.delegate.fullPath)

}