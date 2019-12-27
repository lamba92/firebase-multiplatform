package com.github.lamba92.firebasemultiplatform.storage

import android.net.Uri
import com.google.firebase.storage.FileDownloadTask
import kotlinx.io.core.Input
import java.io.InputStream

fun FileDownloadTask.TaskSnapshot.toMpp() =
    DownloadTask.Snapshot(this)

fun PlatformSpecificStorageReference.toMpp() =
    StorageReference(this)

fun PlatformSpecificFirebaseStorage.toMpp() =
    FirebaseStorage(this)

fun PlatformSpecificUploadTaskSnapshot.toMpp() =
    UploadTask.Snapshot(this)

fun PlatformSpecificStorageMetadata.toMpp() =
    StorageMetadata(this)

fun PlatformSpecificStreamDownloadTaskSnapshot.toMpp() =
    StreamDownloadTask.Snapshot(this)

fun PlatformSpecificDownloadTask.toMpp() =
    DownloadTask(this)

fun PlatformSpecificUploadTask.toMpp() =
    UploadTask(this)

fun PlatformSpecificStreamDownloadTask.toMpp() =
    StreamDownloadTask(this)

fun PlatformSpecificListResult.toMpp() =
    ListResult(this)

fun String.toUri(): Uri =
    Uri.parse(this)!!

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