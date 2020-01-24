package com.github.lamba92.firebasemultiplatform.storage

import com.google.firebase.*
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.usePinned
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import platform.Foundation.*
import platform.posix.memcpy

typealias ImageBytes = NSData

@ExperimentalUnsignedTypes
fun ImageBytes.toByteArray(): ByteArray = ByteArray(this@toByteArray.length.toInt()).apply {
    usePinned {
        memcpy(it.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
    }
}

fun ByteArray.toImageBytes(): ImageBytes = memScoped {
    val string = NSString.create(string = this@toImageBytes.decodeToString())
    return string.dataUsingEncoding(NSUTF8StringEncoding)!!
}

fun FIRStorageReference.toMpp() =
    StorageReference(this)

fun FIRStorageTaskStatus.toMpp() = when (this) {
    FIRStorageTaskStatus.FIRStorageTaskStatusUnknown -> StorageTask.Snapshot.State.UNKNOWN
    FIRStorageTaskStatus.FIRStorageTaskStatusResume -> StorageTask.Snapshot.State.RUNNING
    FIRStorageTaskStatus.FIRStorageTaskStatusProgress -> StorageTask.Snapshot.State.RUNNING
    FIRStorageTaskStatus.FIRStorageTaskStatusPause -> StorageTask.Snapshot.State.PAUSED
    FIRStorageTaskStatus.FIRStorageTaskStatusSuccess -> StorageTask.Snapshot.State.FINISHED_SUCCESSFULLY
    FIRStorageTaskStatus.FIRStorageTaskStatusFailure -> StorageTask.Snapshot.State.ERRORED
}

fun FIRStorageTaskSnapshot.toMppUploadTaskSnapshot() =
    UploadTask.Snapshot(this)

fun FIRStorage.toMpp() =
    FirebaseStorage(this)

fun FIRStorageListResult.toMpp() =
    StorageListResult(this)

fun FIRStorageMetadata.toMpp() =
    StorageMetadata(this)

@ExperimentalCoroutinesApi
internal val FIRStorageObservableTask.statusFlow
    get() = callbackFlow {
        val handlers = listOf(
            FIRStorageTaskStatus.FIRStorageTaskStatusUnknown,
            FIRStorageTaskStatus.FIRStorageTaskStatusFailure,
            FIRStorageTaskStatus.FIRStorageTaskStatusSuccess,
            FIRStorageTaskStatus.FIRStorageTaskStatusPause,
            FIRStorageTaskStatus.FIRStorageTaskStatusResume
        )
            .map { status ->
                observeStatus(status) {
                    offer(status.toMpp())
                }!!
            }
        awaitClose { handlers.forEach { removeObserverWithHandle(it) } }
    }


fun FIRStorageUploadTask.toMpp() =
    UploadTask(this)