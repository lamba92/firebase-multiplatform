package com.github.lamba92.firebasemultiplatform.storage

import android.net.Uri
import com.github.lamba92.firebasemultiplatform.core.await
import kotlinx.io.core.Input
import java.io.InputStream

actual suspend fun StorageReference.getBytes(maxDownloadSize: Long) =
    delegate.getBytes(maxDownloadSize).await()!!

actual fun StorageReference.getFile(uri: String) =
    delegate.getFile(Uri.parse(uri)).toMpp()

actual fun StorageReference.getStream() =
    delegate.stream.toMpp()

fun StorageReference.putFile(uri: Uri, metadata: StorageMetadata, existingUploadUri: Uri): UploadTask =
    delegate.putFile(uri, metadata.delegate, existingUploadUri).toMpp()

fun StorageReference.putFile(uri: Uri, metadata: StorageMetadata): UploadTask =
    delegate.putFile(uri, metadata.delegate).toMpp()

fun StorageReference.putFile(uri: Uri): UploadTask =
    delegate.putFile(uri).toMpp()

actual fun StorageReference.putFile(uri: String, metadata: StorageMetadata, existingUploadUri: String): UploadTask =
    putFile(uri.toUri(), metadata, existingUploadUri.toUri())

actual fun StorageReference.putFile(uri: String, metadata: StorageMetadata): UploadTask =
    putFile(uri.toUri(), metadata)

actual fun StorageReference.putFile(uri: String): UploadTask =
    putFile(uri.toUri())

actual fun StorageReference.putStream(stream: Input, metadata: StorageMetadata): UploadTask =
    putStream(stream.asStream(), metadata)

actual fun StorageReference.putStream(stream: Input): UploadTask =
    putStream(stream.asStream())

fun PlatformSpecificStreamDownloadTaskSnapshot.toMpp() =
    StreamDownloadTask.Snapshot(this)

fun PlatformSpecificStreamDownloadTask.toMpp() =
    StreamDownloadTask(this)

// shamefully copied from ktor jvm utils
fun Input.asStream(): InputStream = object : InputStream() {

    override fun read(): Int = tryPeek()

    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        if (this@asStream.endOfInput) return -1
        return readAvailable(buffer, offset, length)
    }

    override fun skip(count: Long): Long = discard(count)

    override fun close() {
        this@asStream.close()
    }
}