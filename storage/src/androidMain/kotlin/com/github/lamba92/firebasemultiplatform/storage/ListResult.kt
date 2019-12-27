package com.github.lamba92.firebasemultiplatform.storage

actual class ListResult(
    val delegate: PlatformSpecificListResult
) {

    actual val items by lazy {
        delegate.items.map { it.toMpp() }
    }

    actual val pageToken: String?
        get() = delegate.pageToken

    actual val prefixes by lazy {
        delegate.items.map { it.toMpp() }
    }

}