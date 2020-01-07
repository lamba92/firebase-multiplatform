package com.github.lamba92.firebasemultiplatform.storage

operator fun StorageMetadata.get(key: String) =
    getCustomMetadata(key)

fun StorageMetadata.Companion.build(
    original: StorageMetadata? = null,
    builder: StorageMetadata.Builder.() -> Unit
) = StorageMetadata.Builder(original).apply(builder).build()

fun StorageMetadata.edit(builder: StorageMetadata.Builder.() -> Unit) =
    StorageMetadata.build(this, builder)

