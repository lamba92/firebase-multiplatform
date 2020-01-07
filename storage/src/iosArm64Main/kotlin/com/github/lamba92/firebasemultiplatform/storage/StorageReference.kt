@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.resume
import com.github.lamba92.firebasemultiplatform.core.resumeWithException
import com.google.firebase.FIRStorageReference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

actual class StorageReference(
    val delegate: FIRStorageReference
) : Comparable<StorageReference> {

    actual val bucket: String
        get() = delegate.bucket
    actual val name: String
        get() = delegate.name
    actual val parent: StorageReference?
        get() = delegate.parent()?.toMpp()
    actual val path: String
        get() = delegate.fullPath
    actual val root: StorageReference
        get() = delegate.root().toMpp()
    actual val storage: FirebaseStorage
        get() = delegate.storage.toMpp()

    actual fun child(pathString: String) =
        delegate.child(pathString).toMpp()

    @ExperimentalCoroutinesApi
    actual suspend fun delete() = suspendCancellableCoroutine<Unit> { cont ->
        delegate.deleteWithCompletion {
            it?.let { cont.resumeWithException(it) }
                ?: cont.resume()
        }
    }

    actual suspend fun downloadUrl() = suspendCancellableCoroutine<String> { cont ->
        delegate.downloadURLWithCompletion { nsurl, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: nsurl?.let { cont.resume(it.absoluteString!!) }
        }
    }

    actual suspend fun getMetadata() = suspendCancellableCoroutine<StorageMetadata> { cont ->
        delegate.metadataWithCompletion { firStorageMetadata, nsError ->
            nsError?.let { cont.resumeWithException(it) }
                ?: firStorageMetadata?.let { cont.resume(it.toMpp()) }
        }
    }

    actual suspend fun list(maxResults: Int, pageToken: String) =
        suspendCancellableCoroutine<StorageListResult> { cont ->
            delegate.listWithMaxResults(maxResults.toLong(), pageToken) { firStorageListResult, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: firStorageListResult?.let { cont.resume(it.toMpp()) }
            }
        }

    actual suspend fun list(maxResults: Int) =
        suspendCancellableCoroutine<StorageListResult> { cont ->
            delegate.listWithMaxResults(maxResults.toLong()) { firStorageListResult, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: firStorageListResult?.let { cont.resume(it.toMpp()) }
            }
        }

    actual suspend fun listAll() =
        suspendCancellableCoroutine<StorageListResult> { cont ->
            delegate.listAllWithCompletion { firStorageListResult, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: firStorageListResult?.let { cont.resume(it.toMpp()) }
            }
        }

    actual fun putBytes(bytes: ByteArray, metadata: StorageMetadata) =
        delegate.putData(bytes.toImageBytes(), metadata.delegate).toMpp()

    actual fun putBytes(bytes: ByteArray) =
        delegate.putData(bytes.toImageBytes()).toMpp()

    actual override fun toString() =
        delegate.fullPath

    actual suspend fun updateMetadata(metadata: StorageMetadata) =
        suspendCancellableCoroutine<StorageMetadata> { cont ->
            delegate.updateMetadata(metadata.delegate) { firStorageMetadata, nsError ->
                nsError?.let { cont.resumeWithException(it) }
                    ?: firStorageMetadata?.let { cont.resume(it.toMpp()) }
            }
        }

    override fun compareTo(other: StorageReference) =
        delegate.fullPath.compareTo(other.delegate.fullPath)

}