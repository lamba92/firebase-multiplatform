package com.github.lamba92.firebasemultiplatform.storage

import kotlinx.io.core.Input

expect class StreamDownloadTask : StorageTask<StreamDownloadTask.Snapshot> {

    class Snapshot : StorageTask.Snapshot {
        val stream: Input
    }

}
