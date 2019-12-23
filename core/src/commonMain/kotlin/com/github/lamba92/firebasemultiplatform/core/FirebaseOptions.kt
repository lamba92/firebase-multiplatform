package com.github.lamba92.firebasemultiplatform.core

expect class FirebaseOptions(
    delegate: PlatformSpecificFirebaseOptions
) {

    val delegate: PlatformSpecificFirebaseOptions

    companion object {
        fun build(action: FirebaseOptionsBuilder.() -> Unit): FirebaseOptions
    }

    val apiKey: String
    val applicationId: String
    val databaseUrl: String?
    val gcmSenderId: String?
    val projectId: String?
    val storageBucket: String?

}