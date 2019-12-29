package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

expect class FirebaseStorage {

    val app: FirebaseApp

    @ExperimentalTime
    var maxDownloadRetryTime: Duration

    @ExperimentalTime
    var maxUploadRetryTime: Duration

    @ExperimentalTime
    var maxOperationRetryTime: Duration

    val rootReference: StorageReference

    companion object {
        val default: FirebaseStorage
        fun getInstance(url: String): FirebaseStorage
        fun getInstance(app: FirebaseApp, url: String): FirebaseStorage
    }

    fun getReference(location: String): StorageReference

    fun getReferenceFromUrl(fullUrl: String): StorageReference

}
