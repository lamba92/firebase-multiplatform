package com.github.lamba92.firebasemultiplatform.storage

import kotlinx.coroutines.flow.Flow

actual class DownloadTask : StorageTask<DownloadTask.Snapshot> {
    override val isCanceled: Boolean
        get() = TODO("not implemented")

    override val isComplete: Boolean
        get() = TODO("not implemented")
    override val isInProgress: Boolean
        get() = TODO("not implemented")
    override val isPaused: Boolean
        get() = TODO("not implemented")
    override val isSuccessful: Boolean
        get() = TODO("not implemented")
    override val progressFlow: Flow<Snapshot>
        get() = TODO("not implemented")
    override val stateChangesFlow: Flow<StorageTask.Snapshot.State>
        get() = TODO("not implemented")
    override val snapshot: Snapshot
        get() = TODO("not implemented")

    override fun cancel() {
        TODO("not implemented")
    }

    override fun pause() {
        TODO("not implemented")
    }

    override fun resume() {
        TODO("not implemented")
    }

    override suspend fun await() {
        TODO("not implemented")
    }

    actual class Snapshot : StorageTask.Snapshot {

        override val storage: StorageReference
            get() = TODO("not implemented")
        override val bytesTransferred: Long
            get() = TODO("not implemented")
        override val totalByteCount: Long
            get() = TODO("not implemented")

    }
}