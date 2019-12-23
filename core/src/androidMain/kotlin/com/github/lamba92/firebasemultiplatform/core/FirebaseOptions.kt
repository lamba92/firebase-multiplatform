package com.github.lamba92.firebasemultiplatform.core

import com.google.firebase.FirebaseOptions

actual class FirebaseOptions actual constructor(
    actual val delegate: PlatformSpecificFirebaseOptions
) {

    actual companion object {
        actual fun build(action: FirebaseOptionsBuilder.() -> Unit) =
            FirebaseOptionsBuilder()
                .apply(action)
                .let {
                    FirebaseOptions.Builder()
                        .apply {
                            setApiKey(it.apiKey!!)
                            setApplicationId(it.applicationId!!)
                            setDatabaseUrl(it.databaseUrl)
                            setGcmSenderId(it.gcmSenderId)
                            setProjectId(it.projectId)
                            setStorageBucket(it.storageBucket)
                        }
                        .build()
                }
                .toMpp()
    }

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

}