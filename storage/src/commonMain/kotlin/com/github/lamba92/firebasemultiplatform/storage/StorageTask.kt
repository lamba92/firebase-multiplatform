package com.github.lamba92.firebasemultiplatform.storage

import kotlinx.coroutines.flow.Flow

interface StorageTask<T : StorageTask.Snapshot> {

    val isCanceled: Boolean
    val isComplete: Boolean
    val isInProgress: Boolean
    val isPaused: Boolean
    val isSuccessful: Boolean
    val progressFlow: Flow<T>
    val stateChangesFlow: Flow<Snapshot.State>
    val snapshot: T

    fun cancel()
    fun pause()
    fun resume()
    suspend fun await()

    interface Snapshot {

        val storage: StorageReference

        val bytesTransferred: Long
        val totalByteCount: Long

        val progressPercentage
            get() = 100.0 * bytesTransferred / totalByteCount

        enum class State {
            PAUSED, RUNNING, CANCELED, FINISHED_SUCCESSFULLY, ERRORED, UNKNOWN
        }

    }

}