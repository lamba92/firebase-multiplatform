package com.github.lamba92.firebasemultiplatform.storage

import firebase.storage.ListResult

actual class StorageListResult(val delegate: ListResult) {

    actual val items: List<StorageReference>
        get() = delegate.items.map { it.toMpp() }
    actual val pageToken: String?
        get() = delegate.nextPageToken
    actual val prefixes: List<StorageReference>
        get() = delegate.prefixes.map { it.toMpp() }

}