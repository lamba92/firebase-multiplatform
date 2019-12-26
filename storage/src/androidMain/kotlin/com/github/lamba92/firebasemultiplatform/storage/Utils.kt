package com.github.lamba92.firebasemultiplatform.storage

import com.google.firebase.storage.FileDownloadTask

fun FileDownloadTask.TaskSnapshot.toMpp() =
    DownloadTask.Snapshot(this)

fun PlatformSpecificStorageReference.toMpp() =
    StorageReference(this)

fun PlatformSpecificFirebaseStorage.toMpp() =
    FirebaseStorage(this)

fun PlatformSpecificUploadTaskSnapshot.toMpp() =
    UploadTask.Snapshot(this)

fun PlatformSpecificStorageMetadata.toMpp() =
    StorageMetadata(this)