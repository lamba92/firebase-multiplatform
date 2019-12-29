package com.github.lamba92.firebasemultiplatform.core

expect class FirebaseOptions {

    companion object

    val apiKey: String
    val applicationId: String
    val databaseUrl: String?
    val gcmSenderId: String?
    val projectId: String?
    val storageBucket: String?

    class Builder() {

        companion object

        fun build(): FirebaseOptions
        fun setApiKey(apiKey: String): Builder
        fun setApplicationId(applicationId: String): Builder
        fun setDatabaseUrl(databaseUrl: String): Builder
        fun setGcmSenderId(gcmSenderId: String): Builder
        fun setProjectId(projectId: String): Builder
        fun setStorageBucket(storageBucket: String): Builder

    }

}