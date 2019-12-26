package com.github.lamba92.firebasemultiplatform.storage

import android.net.Uri
import com.google.firebase.storage.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import java.io.File

typealias PlatformSpecificStorageReference = StorageReference
typealias PlatformSpecificDownloadTask = FileDownloadTask
typealias PlatformSpecificUploadTask = UploadTask
typealias PlatformSpecificUploadTaskSnapshot = UploadTask.TaskSnapshot
typealias PlatformSpecificUri = Uri
typealias PlatformSpecificFile = File
typealias PlatformSpecificStorageMetadata = StorageMetadata
typealias PlatformSpecificFirebaseStorage = FirebaseStorage
typealias PlatformSpecificListResult = ListResult
typealias PSStorageTask<T> = StorageTask<T>