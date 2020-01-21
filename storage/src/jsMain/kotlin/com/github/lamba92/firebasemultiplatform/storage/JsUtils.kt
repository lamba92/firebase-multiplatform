package com.github.lamba92.firebasemultiplatform.storage

import firebase.storage.FullMetadata
import firebase.storage.Reference
import firebase.storage.Storage
import firebase.storage.UploadTaskSnapshot

fun Storage.toMpp() =
    FirebaseStorage(this)

fun Reference.toMpp() =
    StorageReference(this)

fun UploadTaskSnapshot.toMpp() =
    UploadTask.Snapshot(this)

fun FullMetadata.toMpp() =
    StorageMetadata(this)

fun firebase.storage.UploadTask.toMpp() =
    UploadTask(this)

fun firebase.storage.ListResult.toMpp() =
    StorageListResult(this)