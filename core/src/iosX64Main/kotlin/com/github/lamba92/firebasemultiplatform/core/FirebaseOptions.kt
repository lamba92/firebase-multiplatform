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

        actual var apiKey: String?
            get() = delegate.APIKey
            set(value) {
                delegate.setAPIKey(value)
            }
        actual var applicationId: String?
            get() = delegate.googleAppID
            set(value) {
                value?.let { delegate.setGoogleAppID(it) }
            }
        actual var databaseUrl: String?
            get() = delegate.databaseURL
            set(value) {
                delegate.setDatabaseURL(value)
            }
        actual var gcmSenderId: String?
            get() = delegate.GCMSenderID
            set(value) {
                value?.let { delegate.setGCMSenderID(it) }
            }
        actual var projectId: String?
            get() = delegate.projectID
            set(value) {
                delegate.setProjectID(value)
            }
        actual var storageBucket: String?
            get() = delegate.storageBucket
            set(value) {
                delegate.setStorageBucket(value)
            }


    }

}