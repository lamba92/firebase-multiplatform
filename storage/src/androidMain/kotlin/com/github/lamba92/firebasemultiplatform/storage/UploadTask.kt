package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.resume
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.OnPausedListener
import com.google.firebase.storage.OnProgressListener
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.suspendCancellableCoroutine

actual class UploadTask(
    val delegate: PlatformSpecificUploadTask
) : StorageTask<UploadTask.Snapshot> {

    override val isCanceled: Boolean
        get() = delegate.isCanceled
    override val isComplete: Boolean
        get() = delegate.isComplete
    override val isInProgress: Boolean
        get() = delegate.isInProgress
    override val isPaused: Boolean
        get() = delegate.isPaused
    override val isSuccessful: Boolean
        get() = delegate.isSuccessful

    @ExperimentalCoroutinesApi
    override val progressFlow: Flow<Snapshot> by lazy {
        callbackFlow {
            val progressCallback =
                OnProgressListener<com.google.firebase.storage.UploadTask.TaskSnapshot> { offer(it.toMpp()) }
            delegate.addOnProgressListener(progressCallback)
            awaitClose { delegate.removeOnProgressListener(progressCallback) }
        }
    }

    @ExperimentalCoroutinesApi
    override val stateChangesFlow by lazy {
        callbackFlow {
            val pauseCallback = OnPausedListener<PlatformSpecificUploadTaskSnapshot> {
                offer(StorageTask.Snapshot.State.PAUSED)
            }
            val cancelCallback = OnCanceledListener {
                offer(StorageTask.Snapshot.State.CANCELED)
            }
            val successCallback = OnSuccessListener<PlatformSpecificUploadTaskSnapshot> {
                offer(StorageTask.Snapshot.State.FINISHED_SUCCESSFULLY)
            }
            val progressCallback = OnProgressListener<PlatformSpecificUploadTaskSnapshot> {
                offer(StorageTask.Snapshot.State.RUNNING)
            }
            val errorCallback = OnFailureListener {
                offer(StorageTask.Snapshot.State.ERRORED)
            }
            with(delegate) {
                addOnPausedListener(pauseCallback)
                addOnCanceledListener(cancelCallback)
                addOnSuccessListener(successCallback)
                addOnProgressListener(progressCallback)
                addOnFailureListener(errorCallback)
            }
            awaitClose {
                with(delegate) {
                    removeOnPausedListener(pauseCallback)
                    removeOnCanceledListener(cancelCallback)
                    removeOnSuccessListener(successCallback)
                    removeOnProgressListener(progressCallback)
                }
            }
        }
            .distinctUntilChanged()
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
        val l = OnCompleteListener<com.google.firebase.storage.UploadTask.TaskSnapshot> {
            cont.resume()
        }
        delegate.addOnCompleteListener(l)
        cont.invokeOnCancellation { delegate.removeOnCompleteListener(l) }
    }

    actual class Snapshot(
        val delegate: PlatformSpecificUploadTaskSnapshot
    ) : StorageTask.Snapshot {

        override val storage: StorageReference
            get() = delegate.storage.toMpp()

        override val bytesTransferred: Long
            get() = delegate.bytesTransferred

        override val totalByteCount: Long
            get() = delegate.totalByteCount

        actual val metadata: StorageMetadata?
            get() = delegate.metadata?.toMpp()

        val uploadSessionUri: String?
            get() = delegate.uploadSessionUri?.toString()

    }

}