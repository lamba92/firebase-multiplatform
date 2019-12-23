package com.github.lamba92.firebasemultiplatform.core

data class FirebaseOptionsBuilder(
    var apiKey: String? = null,
    var applicationId: String? = null,
    var databaseUrl: String? = null,
    var gcmSenderId: String? = null,
    var projectId: String? = null,
    var storageBucket: String? = null
)