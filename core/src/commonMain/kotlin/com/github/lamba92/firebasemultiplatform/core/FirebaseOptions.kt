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

        var apiKey: String?
        var applicationId: String?
        var databaseUrl: String?
        var gcmSenderId: String?
        var projectId: String?
        var storageBucket: String?

        fun build(): FirebaseOptions

    }

}