package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.toMpp
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

actual class FirebaseStorage(
    val delegate: PlatformSpecificFirebaseStorage
) {

    actual val app: FirebaseApp
        get() = delegate.app.toMpp()

    @ExperimentalTime
    actual var maxDownloadRetryTime: Duration
        get() = delegate.maxDownloadRetryTimeMillis.toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.maxDownloadRetryTimeMillis = value.toLongMilliseconds()
        }

    @ExperimentalTime
    actual var maxUploadRetryTime: Duration
        get() = delegate.maxUploadRetryTimeMillis.toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.maxUploadRetryTimeMillis = value.toLongMilliseconds()
        }

    @ExperimentalTime
    actual var maxOperationRetryTime: Duration
        get() = delegate.maxOperationRetryTimeMillis.toDuration(DurationUnit.MILLISECONDS)
        set(value) {
            delegate.maxOperationRetryTimeMillis = value.toLongMilliseconds()
        }

    actual val rootReference: StorageReference
        get() = delegate.reference.toMpp()

    actual companion object {

        actual val default: FirebaseStorage
            get() = PlatformSpecificFirebaseStorage.getInstance().toMpp()

        actual fun getInstance(url: String) =
            PlatformSpecificFirebaseStorage.getInstance(url).toMpp()

        actual fun getInstance(app: FirebaseApp, url: String) =
            PlatformSpecificFirebaseStorage.getInstance(app.delegate, url).toMpp()
    }

    actual fun getReference(location: String) =
        delegate.getReference(location).toMpp()

    actual fun getReferenceFromUrl(fullUrl: String) =
        delegate.getReferenceFromUrl(fullUrl).toMpp()

}