package com.github.lamba92.firebasemultiplatform.storage

actual class StreamDownloadTask : StorageTask<StreamDownloadTask.Snapshot> {
    actual class Snapshot : StorageTask.Snapshot {
        actual val stream: kotlinx.io.core.Input
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    }

}