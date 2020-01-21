package com.github.lamba92.firebasemultiplatform.core

actual class FirebaseOptions(
    val delegate: PlatformSpecificFirebaseOptions
) {

    actual companion object;

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

        actual companion object;

        actual fun build(): FirebaseOptions {
            val a = apiKey
            val a2 = applicationId
            require(a != null) { "apiKey cannot be null" }
            require(a2 != null) { "applicationId cannot be null" }
            return com.google.firebase.FirebaseOptions.Builder().apply {
                setApiKey(a)
                setApplicationId(a2)
                setDatabaseUrl(databaseUrl)
                setGcmSenderId(gcmSenderId)
                setProjectId(projectId)
                setStorageBucket(storageBucket)
            }.build().toMpp()
        }

        actual var apiKey: String? = null
        actual var applicationId: String? = null
        actual var databaseUrl: String? = null
        actual var gcmSenderId: String? = null
        actual var projectId: String? = null
        actual var storageBucket: String? = null

    }

}