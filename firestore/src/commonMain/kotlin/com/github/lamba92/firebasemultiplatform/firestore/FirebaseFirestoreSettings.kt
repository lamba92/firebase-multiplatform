package com.github.lamba92.firebasemultiplatform.firestore

expect class FirebaseFirestoreSettings {

    val areTimestampsInSnapshotsEnabled: Boolean
    val cacheSizeBytes: Long
    val host: String
    val isPersistenceEnabled: Boolean
    val isSslEnabled: Boolean

    class Builder(original: FirebaseFirestoreSettings? = null) {
        var cacheSizeBytes: Long
        var host: String
        var isPersistenceEnable: Boolean
        var isSslEnabled: Boolean

        fun build(): FirebaseFirestoreSettings
    }

}
