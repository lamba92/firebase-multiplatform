package com.github.lamba92.firebasemultiplatform.storage

import com.github.lamba92.firebasemultiplatform.core.PrimitiveHashMap
import firebase.storage.FullMetadata
import firebase.storage.SettableMetadata

actual class StorageMetadata(val delegate: FullMetadata) {
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
        get() = delegate.timeCreated?.toLong()

    actual val customMetadataKeys: Set<String>
        get() = PrimitiveHashMap<String>(delegate.customMetadata).keys

    actual val generation: String?
        get() = delegate.generation

    actual val md5Hash: String?
        get() = delegate.md5Hash

    actual val metadataGeneration: String?
        get() = delegate.metageneration

    actual val name: String?
        get() = delegate.name

    actual val path: String?
        get() = delegate.fullPath

    actual val sizeBytes: Long?
        get() = delegate.size?.toLong()

    actual val updatedTimeMillis: Long?
        get() = delegate.updated?.toLong()

    actual fun getCustomMetadata(key: String) =
        PrimitiveHashMap<String>(delegate.customMetadata)[key]

    actual class Builder actual constructor(original: StorageMetadata?) {

        private val delegate: SettableMetadata = original?.delegate ?: object : SettableMetadata {
            override var cacheControl: String? = null
            override var contentDisposition: String? = null
            override var contentEncoding: String? = null
            override var contentLanguage: String? = null
            override var contentType: String? = null
            override var customMetadata = PrimitiveHashMap<String>()
        }

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
            StorageMetadata(object : FullMetadata, SettableMetadata by delegate {
                override var bucket: String? = null
                override var downloadURLs: Array<String>? = null
                override var fullPath: String? = null
                override var generation: String? = null
                override var metageneration: String? = null
                override var name: String? = null
                override var size: Number? = null
                override var timeCreated: String? = null
                override var updated: String? = null
            })

        actual fun setCustomMetadata(key: String, value: String) {
            PrimitiveHashMap<String>(delegate.customMetadata)[key] = value
        }

    }

}