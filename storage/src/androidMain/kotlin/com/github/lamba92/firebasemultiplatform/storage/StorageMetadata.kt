package com.github.lamba92.firebasemultiplatform.storage

actual class StorageMetadata(
    val delegate: PlatformSpecificStorageMetadata
) {

    actual companion object {}

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

    actual val contentCreationTimeMillis: Long
        get() = delegate.creationTimeMillis

    actual val customMetadataKeys: Set<String>
        get() = delegate.customMetadataKeys

    actual val generation: String?
        get() = delegate.generation

    actual val md5Hash: String?
        get() = delegate.md5Hash

    actual val metadataGeneration: String?
        get() = delegate.metadataGeneration

    actual val name: String?
        get() = delegate.name

    actual val path: String
        get() = delegate.path

    actual val reference: StorageReference?
        get() = delegate.reference?.toMpp()

    actual val sizeBytes: Long
        get() = delegate.sizeBytes

    actual val updatedTimeMillis: Long
        get() = delegate.updatedTimeMillis

    actual fun getCustomMetadata(key: String) =
        delegate.getCustomMetadata(key)

    actual class Builder actual constructor(
        original: StorageMetadata?
    ) {

        val delegate = if (original == null)
            PlatformSpecificStorageMetadataBuilder()
        else
            PlatformSpecificStorageMetadataBuilder(original.delegate)

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
            delegate.build().toMpp()

        actual fun setCustomMetadata(key: String, value: String) {
            delegate.setCustomMetadata(key, value)
        }

    }


}