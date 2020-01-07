package com.github.lamba92.firebasemultiplatform.storage

import com.google.firebase.FIRStorageListResult
import com.google.firebase.FIRStorageReference

actual class StorageListResult(val delegate: FIRStorageListResult) {
    actual val items: List<StorageReference>
        get() = delegate.items.mapNotNull { (it as? FIRStorageReference)?.toMpp() }
    actual val pageToken: String?
        get() = delegate.pageToken
    actual val prefixes: List<StorageReference>
        get() = delegate.prefixes.mapNotNull { (it as? FIRStorageReference)?.toMpp() }
}