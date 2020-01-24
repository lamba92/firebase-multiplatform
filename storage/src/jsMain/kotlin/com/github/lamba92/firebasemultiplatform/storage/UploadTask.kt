package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.resume
import firebase.CompleteFn
import firebase.ErrorFn
import firebase.NextFn
import firebase.Observer
import firebase.storage.TaskEvent
import firebase.storage.TaskState
import firebase.storage.UploadTaskSnapshot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine

actual class UploadTask(val delegate: firebase.storage.UploadTask) : StorageTask<UploadTask.Snapshot> {

    actual class Snapshot(val delegate: firebase.storage.UploadTaskSnapshot) : StorageTask.Snapshot {
        actual val metadata: StorageMetadata?
            get() = delegate.metadata.toMpp()
        override val storage: StorageReference
            get() = delegate.ref.toMpp()
        override val bytesTransferred: Long
            get() = delegate.bytesTransferred.toLong()
        override val totalByteCount: Long
            get() = delegate.totalBytes.toLong()
    }

    override val isCanceled: Boolean
        get() = delegate.snapshot.state == TaskState.CANCELED

    override val isComplete: Boolean
        get() = delegate.snapshot.state == TaskState.SUCCESS

    override val isInProgress: Boolean
        get() = delegate.snapshot.state == TaskState.RUNNING

    override val isPaused: Boolean
        get() = delegate.snapshot.state == TaskState.PAUSED

    override val isSuccessful: Boolean
        get() = delegate.snapshot.state == TaskState.SUCCESS

    @ExperimentalCoroutinesApi
    override val progressFlow by lazy {
        callbackFlow {
            val unsubscriber = delegate.on(TaskEvent.STATE_CHANGED,
                nextOrObserver = object : Observer<UploadTaskSnapshot, Error> {
                    override var next: NextFn<UploadTaskSnapshot> = {
                        offer(it.toMpp())
                    }
                    override var error: ErrorFn<Error> = {
                        close(it)
                    }
                    override var complete: CompleteFn = {}
                }
            )
            awaitClose { unsubscriber() }
        }
    }

    @ExperimentalCoroutinesApi
    override val stateChangesFlow by lazy {
        callbackFlow {
            val unsubscriber = delegate.on(TaskEvent.STATE_CHANGED,
                nextOrObserver = object : Observer<UploadTaskSnapshot, Error> {
                    override var next: NextFn<UploadTaskSnapshot> = {
                        offer(
                            when (it.state) {
                                TaskState.SUCCESS -> StorageTask.Snapshot.State.FINISHED_SUCCESSFULLY
                                TaskState.PAUSED -> StorageTask.Snapshot.State.PAUSED
                                TaskState.RUNNING -> StorageTask.Snapshot.State.RUNNING
                                TaskState.ERROR -> StorageTask.Snapshot.State.ERRORED
                                TaskState.CANCELED -> StorageTask.Snapshot.State.CANCELED
                                else -> StorageTask.Snapshot.State.UNKNOWN
                            }
                        )
                    }
                    override var error: ErrorFn<Error> = { close(it) }
                    override var complete: CompleteFn = {}
                }
            )
            awaitClose { unsubscriber() }
        }
    }
    override val snapshot: Snapshot
        get() = delegate.snapshot.toMpp()

    override fun cancel() {
        delegate.cancel()
    }

    override fun pause() {
        delegate.pause()
    }

    override fun resume() {
        delegate.resume()
    }

    override suspend fun await() = suspendCancellableCoroutine<Unit> { cont ->
        val handles = listOf(TaskState.CANCELED, TaskState.ERROR, TaskState.SUCCESS)
            .map {
                delegate.on(it, object : Observer<UploadTaskSnapshot, Error> {
                    override var next: NextFn<UploadTaskSnapshot> = { cont.resume() }
                    override var error: ErrorFn<Error> = {}
                    override var complete: CompleteFn = {}
                })
            }
            cont.invokeOnCancellation { handles.forEach { it() } }
    }

}