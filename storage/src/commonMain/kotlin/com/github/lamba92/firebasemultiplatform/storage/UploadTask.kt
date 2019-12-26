package com.github.lamba92.firebasemultiplatform.storage

expect class UploadTask : StorageTask<UploadTask.Snapshot> {

    class Snapshot : StorageTask.Snapshot {
        val metadata: StorageMetadata?
        val uploadSessionUri: String?
    }

}
