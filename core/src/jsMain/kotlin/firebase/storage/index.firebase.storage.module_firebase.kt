@file:JsQualifier("firebase.storage")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.storage

import firebase.Observer
import firebase.Unsubscribe
import firebase.app.App
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import org.w3c.files.Blob
import kotlin.js.Promise

external interface FullMetadata : UploadMetadata {
    var bucket: String?
    var downloadURLs: Array<String>?
    var fullPath: String?
    var generation: String?
    var metageneration: String?
    var name: String?
    var size: Number?
    var timeCreated: String?
    var updated: String?
}

external interface Reference {
    var bucket: String
    fun child(path: String): Reference
    fun delete(): Promise<Any>
    var fullPath: String
    fun getDownloadURL(): Promise<String>
    fun getMetadata(): Promise<FullMetadata>
    var name: String
    var parent: Reference?
        get() = definedExternally
        set(value) = definedExternally

    fun put(data: Blob, metadata: UploadMetadata? = definedExternally): UploadTask
    fun put(data: Uint8Array, metadata: UploadMetadata? = definedExternally): UploadTask
    fun put(data: ArrayBuffer, metadata: UploadMetadata? = definedExternally): UploadTask
    fun putString(
        data: String,
        format: StringFormat? = definedExternally,
        metadata: UploadMetadata? = definedExternally
    ): UploadTask

    var root: Reference
    var storage: Storage
    override fun toString(): String
    fun updateMetadata(metadata: SettableMetadata): Promise<FullMetadata>
    fun listAll(): Promise<ListResult>
    fun list(options: ListOptions? = definedExternally): Promise<ListResult>
}

external interface ListResult {
    var prefixes: Array<Reference>
    var items: Array<Reference>
    var nextPageToken: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ListOptions {
    var maxResults: Number?
        get() = definedExternally
        set(value) = definedExternally
    var pageToken: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SettableMetadata {
    var cacheControl: String?
        get() = definedExternally
        set(value) = definedExternally
    var contentDisposition: String?
        get() = definedExternally
        set(value) = definedExternally
    var contentEncoding: String?
        get() = definedExternally
        set(value) = definedExternally
    var contentLanguage: String?
        get() = definedExternally
        set(value) = definedExternally
    var contentType: String?
        get() = definedExternally
        set(value) = definedExternally
    var customMetadata: dynamic /* `T$2` | Nothing? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface Storage {
    var app: App
    var maxOperationRetryTime: Number
    var maxUploadRetryTime: Number
    fun ref(path: String? = definedExternally): Reference
    fun refFromURL(url: String): Reference
    fun setMaxOperationRetryTime(time: Number): Any
    fun setMaxUploadRetryTime(time: Number): Any
}

external object StringFormat {
    var BASE64: String
    var BASE64URL: String
    var DATA_URL: String
    var RAW: String
}

external object TaskEvent {
    var STATE_CHANGED: String
}

external object TaskState {
    var CANCELED: String
    var ERROR: String
    var PAUSED: String
    var RUNNING: String
    var SUCCESS: String
}

external interface UploadMetadata : SettableMetadata {
    var md5Hash: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UploadTask {
    fun cancel(): Boolean
    fun catch(onRejected: (a: Error) -> Any): Promise<Any>
    fun on(
        event: String,
        nextOrObserver: Observer<UploadTaskSnapshot, Error>? = definedExternally,
        error: ((a: Error) -> Any)? = definedExternally,
        complete: Unsubscribe? = definedExternally
    ): () -> Unit

    fun on(
        event: String,
        nextOrObserver: Nothing? = definedExternally,
        error: ((a: Error) -> Any)? = definedExternally,
        complete: Unsubscribe? = definedExternally
    ): () -> Unit

    fun on(
        event: String,
        nextOrObserver: ((a: UploadTaskSnapshot) -> Any)? = definedExternally,
        error: ((a: Error) -> Any)? = definedExternally,
        complete: Unsubscribe? = definedExternally
    ): () -> Unit

    fun pause(): Boolean
    fun resume(): Boolean
    var snapshot: UploadTaskSnapshot
    fun then(
        onFulfilled: ((a: UploadTaskSnapshot) -> Any)? = definedExternally,
        onRejected: ((a: Error) -> Any)? = definedExternally
    ): Promise<Any>

    fun on(event: String): Function<*>
}

external interface UploadTaskSnapshot {
    var bytesTransferred: Number
    var downloadURL: String?
        get() = definedExternally
        set(value) = definedExternally
    var metadata: FullMetadata
    var ref: Reference
    var state: String
    var task: UploadTask
    var totalBytes: Number
}