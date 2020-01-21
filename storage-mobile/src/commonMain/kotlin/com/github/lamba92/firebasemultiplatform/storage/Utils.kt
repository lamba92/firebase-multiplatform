package com.github.lamba92.firebasemultiplatform.storage

import kotlinx.io.core.Input

expect fun StorageReference.getFile(uri: String): DownloadTask
expect suspend fun StorageReference.getBytes(maxDownloadSize: Long): ByteArray
expect fun StorageReference.getStream(): StreamDownloadTask
expect fun StorageReference.putFile(uri: String, metadata: StorageMetadata, existingUploadUri: String): UploadTask
expect fun StorageReference.putFile(uri: String, metadata: StorageMetadata): UploadTask
expect fun StorageReference.putFile(uri: String): UploadTask
expect fun StorageReference.putStream(stream: Input, metadata: StorageMetadata): UploadTask
expect fun StorageReference.putStream(stream: Input): UploadTask

expect val StorageReference.activeDownloadTasks: List<DownloadTask>
