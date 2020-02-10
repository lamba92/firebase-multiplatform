@file:JsModule("firebase")
@file:JsNonModule
@file:JsQualifier("app")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.app

import firebase.analytics.Analytics
import firebase.auth.Auth
import firebase.database.Database
import firebase.firestore.Firestore
import firebase.functions.Functions
import firebase.installations.Installations
import firebase.messaging.Messaging
import firebase.performance.Performance
import firebase.remoteConfig.RemoteConfig
import firebase.storage.Storage
import kotlin.js.Promise

external interface App {
    fun auth(): Auth
    fun database(url: String? = definedExternally): Database
    fun delete(): Promise<Any>
    fun installations(): Installations
    fun messaging(): Messaging
    var name: String
    var options: Any
    fun storage(url: String? = definedExternally): Storage
    fun firestore(): Firestore
    fun functions(region: String? = definedExternally): Functions
    fun performance(): Performance
    fun remoteConfig(): RemoteConfig
    fun analytics(): Analytics
}
