@file:JsModule("firebase")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase

import firebase.analytics.Analytics
import firebase.app.App
import firebase.auth.*
import firebase.database.Database
import firebase.firestore.Firestore
import firebase.functions.Functions
import firebase.messaging.Messaging
import firebase.performance.Performance
import firebase.remoteConfig.RemoteConfig
import firebase.storage.Storage
import kotlin.js.Promise

external interface FirebaseError {
    var code: String
    var message: String
    var name: String
    var stack: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Observer<T, E> {
    var next: NextFn<T>
    var error: ErrorFn<E>
    var complete: CompleteFn
}

external var SDK_VERSION: String

external fun registerVersion(library: String, version: String, variant: String? = definedExternally)

external interface `T$0` {
    var displayName: String?
        get() = definedExternally
        set(value) = definedExternally
    var photoURL: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface User : UserInfo {
    fun delete(): Promise<Unit>
    var emailVerified: Boolean
    fun getIdTokenResult(forceRefresh: Boolean? = definedExternally): Promise<IdTokenResult>
    fun getIdToken(forceRefresh: Boolean? = definedExternally): Promise<String>
    var isAnonymous: Boolean
    fun linkAndRetrieveDataWithCredential(credential: AuthCredential): Promise<UserCredential>
    fun linkWithCredential(credential: AuthCredential): Promise<UserCredential>
    fun linkWithPhoneNumber(phoneNumber: String, applicationVerifier: ApplicationVerifier): Promise<ConfirmationResult>
    fun linkWithPopup(provider: AuthProvider): Promise<UserCredential>
    fun linkWithRedirect(provider: AuthProvider): Promise<Unit>
    var metadata: UserMetadata
    override var phoneNumber: String?
        get() = definedExternally
        set(value) = definedExternally
    var providerData: Array<UserInfo?>
    fun reauthenticateAndRetrieveDataWithCredential(credential: AuthCredential): Promise<UserCredential>
    fun reauthenticateWithCredential(credential: AuthCredential): Promise<UserCredential>
    fun reauthenticateWithPhoneNumber(
        phoneNumber: String,
        applicationVerifier: ApplicationVerifier
    ): Promise<ConfirmationResult>

    fun reauthenticateWithPopup(provider: AuthProvider): Promise<UserCredential>
    fun reauthenticateWithRedirect(provider: AuthProvider): Promise<Unit>
    var refreshToken: String
    fun reload(): Promise<Unit>
    fun sendEmailVerification(actionCodeSettings: ActionCodeSettings? = definedExternally): Promise<Unit>
    var tenantId: String?
        get() = definedExternally
        set(value) = definedExternally

    fun toJSON(): Any
    fun unlink(providerId: String): Promise<User>
    fun updateEmail(newEmail: String): Promise<Unit>
    fun updatePassword(newPassword: String): Promise<Unit>
    fun updatePhoneNumber(phoneCredential: AuthCredential): Promise<Unit>
    fun updateProfile(profile: `T$0`): Promise<Unit>
}

external interface UserInfo {
    var displayName: String?
        get() = definedExternally
        set(value) = definedExternally
    var email: String?
        get() = definedExternally
        set(value) = definedExternally
    var phoneNumber: String?
        get() = definedExternally
        set(value) = definedExternally
    var photoURL: String?
        get() = definedExternally
        set(value) = definedExternally
    var providerId: String
    var uid: String
}

external fun app(name: String? = definedExternally): App

external var apps: Array<App>

external fun auth(app: App? = definedExternally): Auth

external fun database(app: App? = definedExternally): Database

external fun initializeApp(options: Any, name: String? = definedExternally): App

external fun messaging(app: App? = definedExternally): Messaging

external fun storage(app: App? = definedExternally): Storage

external fun firestore(app: App? = definedExternally): Firestore

external fun functions(app: App? = definedExternally): Functions

external fun performance(app: App? = definedExternally): Performance

external fun remoteConfig(app: App? = definedExternally): RemoteConfig

external fun analytics(app: App? = definedExternally): Analytics