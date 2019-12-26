package com.github.lamba92.firebasemultiplatform.storage

import kotlinx.io.core.Input

actual class StorageReference(
    val delegate: PlatformSpecificStorageReference
) : Comparator<StorageReference> {

    actual val activeDownloadTasks: List<DownloadTask>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val activeUploadTasks: List<UploadTask>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val bucket: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val name: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val parent: StorageReference
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val path: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val root: StorageReference
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    actual val storage: FirebaseStorage
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    actual fun child(path: String): StorageReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun delete() {
    }

    actual suspend fun getBytes(maxDownloadSize: Long): ByteArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun downloadUrl(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun getStream(): Input {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun getMetadata(): StorageMetadata {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun list(
        maxResults: Int,
        pageToken: String
    ): ListResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun list(maxResults: Int): ListResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun listAll(): ListResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun compare(o1: StorageReference?, o2: StorageReference?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}