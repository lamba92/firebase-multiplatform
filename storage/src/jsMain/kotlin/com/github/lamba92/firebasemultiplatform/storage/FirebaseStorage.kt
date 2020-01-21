package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.toMpp
import firebase.storage.Storage
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

actual class FirebaseStorage(val delegate: Storage) {

    actual val app: FirebaseApp
        get() = delegate.app.toMpp()

    @ExperimentalTime
    actual var maxUploadRetryTime: Duration
        get() = delegate.maxUploadRetryTime.toLong().toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.setMaxUploadRetryTime(value.toLong(DurationUnit.MILLISECONDS))
        }

    @ExperimentalTime
    actual var maxOperationRetryTime: Duration
        get() = delegate.maxOperationRetryTime.toLong().toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.setMaxOperationRetryTime(value.toLong(DurationUnit.MILLISECONDS))
        }

    actual val rootReference: StorageReference
        get() = delegate.ref().toMpp()

    actual companion object {

        actual val default: FirebaseStorage
            get() = firebase.storage().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            firebase.storage(app.delegate).toMpp()
    }

    actual fun getReference(location: String) =
        delegate.ref(location).toMpp()

    actual fun getReferenceFromUrl(fullUrl: String) =
        delegate.refFromURL(fullUrl).toMpp()

}