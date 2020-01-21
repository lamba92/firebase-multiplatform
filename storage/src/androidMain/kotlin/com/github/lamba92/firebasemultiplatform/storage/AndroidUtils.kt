package com.github.lamba92.firebasemultiplatform.storage

import android.net.Uri

fun PlatformSpecificStorageReference.toMpp() =
    StorageReference(this)

fun PlatformSpecificFirebaseStorage.toMpp() =
    FirebaseStorage(this)

fun PlatformSpecificUploadTaskSnapshot.toMpp() =
    UploadTask.Snapshot(this)

fun PlatformSpecificStorageMetadata.toMpp() =
    StorageMetadata(this)

fun PlatformSpecificUploadTask.toMpp() =
    UploadTask(this)

fun PlatformSpecificListResult.toMpp() =
    StorageListResult(this)

fun String.toUri(): Uri =
    Uri.parse(this)!!