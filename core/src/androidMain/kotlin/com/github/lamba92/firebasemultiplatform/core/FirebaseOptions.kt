package com.github.lamba92.firebasemultiplatform.core

actual class FirebaseOptions internal actual constructor(
    actual val delegate: PlatformSpecificFirebaseOptions
) {

    actual companion object {}

    actual val apiKey: String
        get() = delegate.apiKey
    actual val applicationId: String
        get() = delegate.applicationId
    actual val databaseUrl: String?
        get() = delegate.databaseUrl
    actual val gcmSenderId: String?
        get() = delegate.gcmSenderId
    actual val projectId: String?
        get() = delegate.projectId
    actual val storageBucket: String?
        get() = delegate.storageBucket

    actual class Builder actual constructor() {
        actual val delegate: PlatformSpecificFirebaseOptionsBuilder
            get() = PlatformSpecificFirebaseOptionsBuilder()

        actual companion object {}

        actual fun build() =
            delegate.build().toMpp()

        actual fun setApiKey(apiKey: String): Builder {
            delegate.setApiKey(apiKey)
            return this
        }

        actual fun setApplicationId(applicationId: String): Builder {
            delegate.setApplicationId(applicationId)
            return this
        }

        actual fun setDatabaseUrl(databaseUrl: String): Builder {
            delegate.setDatabaseUrl(databaseUrl)
            return this
        }

        actual fun setGcmSenderId(gcmSenderId: String): Builder {
            delegate.setGcmSenderId(gcmSenderId)
            return this
        }

        actual fun setProjectId(projectId: String): Builder {
            delegate.setProjectId(projectId)
            return this
        }

        actual fun setStorageBucket(storageBucket: String): Builder {
            delegate.setStorageBucket(storageBucket)
            return this
        }

    }

}