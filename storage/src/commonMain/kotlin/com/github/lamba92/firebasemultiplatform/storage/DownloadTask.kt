package com.github.lamba92.firebasemultiplatform.storage

expect class DownloadTask : StorageTask<DownloadTask.Snapshot> {
    class Snapshot : StorageTask.Snapshot
}
