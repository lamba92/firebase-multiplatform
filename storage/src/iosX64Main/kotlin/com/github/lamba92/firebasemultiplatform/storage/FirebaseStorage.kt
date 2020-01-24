package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.toMpp
import com.google.firebase.FIRStorage
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

actual class FirebaseStorage(
    val delegate: FIRStorage
) {

    actual val app: FirebaseApp
        get() = delegate.app.toMpp()


    @ExperimentalTime
    actual var maxUploadRetryTime: Duration
        get() = delegate.maxUploadRetryTime.toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.maxUploadRetryTime = value.inMilliseconds
        }
    @ExperimentalTime
    actual var maxOperationRetryTime: Duration
        get() = delegate.maxOperationRetryTime.toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.maxOperationRetryTime = value.inMilliseconds
        }
    actual val rootReference: StorageReference
        get() = delegate.reference().toMpp()

    actual companion object {

        actual val default: FirebaseStorage
            get() = FIRStorage.storage().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            FIRStorage.storageForApp(app.delegate).toMpp()

    }

    actual fun getReference(location: String) =
        delegate.referenceWithPath(location).toMpp()

    actual fun getReferenceFromUrl(fullUrl: String) =
        delegate.referenceForURL(fullUrl).toMpp()

}