package com.github.lamba92.firebasemultiplatform.storage

expect class StorageMetadata {

    companion object

    val bucket: String?
    val cacheControl: String?
    val contentDisposition: String?
    val contentEncoding: String?
    val contentLanguage: String?
    val contentType: String?
    val contentCreationTimeMillis: Long
    val customMetadataKeys: Set<String>
    val generation: String?
    val md5Hash: String?
    val metadataGeneration: String?
    val name: String?
    val path: String
    val reference: StorageReference?
    val sizeBytes: Long
    val updatedTimeMillis: Long

    fun getCustomMetadata(key: String): String?

    class Builder(original: StorageMetadata? = null) {

        var cacheControl: String?
        var contentDisposition: String?
        var contentEncoding: String?
        var contentLanguage: String?
        var contentType: String?

        fun build(): StorageMetadata
        fun setCustomMetadata(key: String, value: String)
    }

}