package com.github.lamba92.firebasemultiplatform.core

actual data class FirebaseOptions(
    @JsName("apiKey") actual val apiKey: String,
    @JsName("authDomain") actual val applicationId: String,
    @JsName("databaseURL") actual val databaseUrl: String?,
    @JsName("messagingSenderId") actual val gcmSenderId: String?,
    @JsName("projectId") actual val projectId: String?,
    @JsName("storageBucket") actual val storageBucket: String?
) {

    actual companion object;

    actual class Builder actual constructor() {

        actual companion object;

        actual fun build(): FirebaseOptions {
            val a = apiKey
            val b = applicationId
            require(a != null) { "apiKey is null" }
            require(b != null) { "applicationId is null" }
            return FirebaseOptions(a, b, databaseUrl, gcmSenderId, projectId, storageBucket)
        }

        actual var apiKey: String? = null
        actual var applicationId: String? = null
        actual var databaseUrl: String? = null
        actual var gcmSenderId: String? = null
        actual var projectId: String? = null
        actual var storageBucket: String? = null

    }

}