package com.github.lamba92.firebasemultiplatform.storage

expect class StorageListResult {
    val items: List<StorageReference>
    val pageToken: String?
    val prefixes: List<StorageReference>
}
