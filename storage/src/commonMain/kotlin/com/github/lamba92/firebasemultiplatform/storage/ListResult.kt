package com.github.lamba92.firebasemultiplatform.storage

expect class ListResult {
    val items: List<StorageReference>
    val pageToken: String?
    val prefixes: List<StorageReference>
}
