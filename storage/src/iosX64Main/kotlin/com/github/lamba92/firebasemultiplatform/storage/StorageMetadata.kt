@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.storage

import com.google.firebase.FIRStorageMetadata

actual class StorageMetadata(val delegate: FIRStorageMetadata) {

    actual companion object;

    actual val bucket: String?
        get() = delegate.bucket
    actual val cacheControl: String?
        get() = delegate.cacheControl
    actual val contentDisposition: String?
        get() = delegate.contentDisposition
    actual val contentEncoding: String?
        get() = delegate.contentEncoding
    actual val contentLanguage: String?
        get() = delegate.contentLanguage
    actual val contentType: String?
        get() = delegate.contentType
    actual val contentCreationTimeMillis: Long?
        get() = delegate.timeCreated()!!.timeIntervalSinceReferenceDate.toLong()
    actual val customMetadataKeys: Set<String>
        get() = delegate.customMetadata?.keys?.mapNotNull { it as? String }?.toSet() ?: emptySet()
    actual val generation: String?
        get() = delegate.generation.toString()
    actual val md5Hash: String?
        get() = delegate.md5Hash
    actual val metadataGeneration: String?
        get() = delegate.metageneration.toString()
    actual val name: String?
        get() = delegate.name
    actual val path: String?
        get() = delegate.path ?: ""
    val reference: StorageReference?
        get() = delegate.storageReference?.toMpp()
    actual val sizeBytes: Long?
        get() = delegate.size
    actual val updatedTimeMillis: Long?
        get() = delegate.updated?.timeIntervalSinceReferenceDate?.toLong() ?: 0L

    actual fun getCustomMetadata(key: String) =
        delegate.customMetadata?.get(key) as? String

    actual class Builder actual constructor(original: StorageMetadata?) {

        val delegate = original?.delegate ?: FIRStorageMetadata()

        actual var cacheControl: String?
            get() = delegate.cacheControl
            set(value) {
                delegate.cacheControl = value
            }
        actual var contentDisposition: String?
            get() = delegate.contentDisposition
            set(value) {
                delegate.contentDisposition = value
            }
        actual var contentEncoding: String?
            get() = delegate.contentEncoding
            set(value) {
                delegate.contentEncoding = value
            }
        actual var contentLanguage: String?
            get() = delegate.contentLanguage
            set(value) {
                delegate.contentLanguage = value
            }
        actual var contentType: String?
            get() = delegate.contentType
            set(value) {
                delegate.contentType = value
            }

        actual fun build() =
            delegate.toMpp()

        actual fun setCustomMetadata(key: String, value: String) {
            delegate.setCustomMetadata(
                (delegate.customMetadata ?: mutableMapOf<Any?, Any>())
                    .toMutableMap()
                    .apply { set(key, value) }
            )
        }

    }

}