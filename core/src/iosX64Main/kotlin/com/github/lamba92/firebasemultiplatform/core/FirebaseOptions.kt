package com.github.lamba92.firebasemultiplatform.core

import com.google.firebase.FIROptions

actual class FirebaseOptions(val delegate: FIROptions) {
    actual companion object;

    actual val apiKey: String
        get() = delegate.APIKey ?: ""
    actual val applicationId: String
        get() = delegate.googleAppID
    actual val databaseUrl: String?
        get() = delegate.databaseURL
    actual val gcmSenderId: String?
        get() = delegate.GCMSenderID
    actual val projectId: String?
        get() = delegate.projectID
    actual val storageBucket: String?
        get() = delegate.storageBucket

    actual class Builder actual constructor() {

        val delegate = FIROptions("", "")

        actual companion object;

        actual fun build() =
            delegate.toMpp()

        actual fun setApiKey(apiKey: String): Builder {
            delegate.APIKey = apiKey
            return this
        }

        actual fun setApplicationId(applicationId: String): Builder {
            delegate.googleAppID = applicationId
            return this
        }

        actual fun setDatabaseUrl(databaseUrl: String): Builder {
            delegate.databaseURL = databaseUrl
            return this
        }

        actual fun setGcmSenderId(gcmSenderId: String): Builder {
            delegate.GCMSenderID = gcmSenderId
            return this
        }

        actual fun setProjectId(projectId: String): Builder {
            delegate.projectID = projectId
            return this
        }

        actual fun setStorageBucket(storageBucket: String): Builder {
            delegate.storageBucket = storageBucket
            return this
        }

    }

}