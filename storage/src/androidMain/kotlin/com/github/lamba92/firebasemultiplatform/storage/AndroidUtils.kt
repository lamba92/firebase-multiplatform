package com.github.lamba92.firebasemultiplatform.storage

import android.net.Uri
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

fun PlatformSpecificDownloadTask.toMpp() =
    DownloadTask(this)

fun PlatformSpecificUploadTask.toMpp() =
    UploadTask(this)

fun PlatformSpecificListResult.toMpp() =
    ListResult(this)

fun String.toUri(): Uri =
    Uri.parse(this)!!