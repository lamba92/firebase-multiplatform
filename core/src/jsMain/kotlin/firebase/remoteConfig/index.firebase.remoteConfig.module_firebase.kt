@file:JsQualifier("firebase.remoteConfig")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.remoteConfig

import kotlin.js.Promise

external interface `T$4`

external interface `T$5`

external interface RemoteConfig {
    var settings: Settings
    var defaultConfig: `T$4`
    var fetchTimeMillis: Number
    var lastFetchStatus: String /* 'no-fetch-yet' | 'success' | 'failure' | 'throttle' */
    fun activate(): Promise<Boolean>
    fun ensureInitialized(): Promise<Unit>
    fun fetch(): Promise<Unit>
    fun fetchAndActivate(): Promise<Boolean>
    fun getAll(): `T$5`
    fun getBoolean(key: String): Boolean
    fun getNumber(key: String): Number
    fun getString(key: String): String
    fun getValue(key: String): Value
    fun setLogLevel(logLevel: String)
}

external interface Value {
    fun asBoolean(): Boolean
    fun asNumber(): Number
    fun asString(): String
    fun getSource(): String /* 'static' | 'default' | 'remote' */
}

external interface Settings {
    var minimumFetchIntervalMillis: Number
    var fetchTimeoutMillis: Number
}