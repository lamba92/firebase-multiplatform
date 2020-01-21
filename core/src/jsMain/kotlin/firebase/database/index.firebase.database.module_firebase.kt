@file:JsQualifier("firebase.database")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.database

import firebase.app.App
import kotlin.js.Promise

external interface DataSnapshot {
    fun child(path: String): DataSnapshot
    fun exists(): Boolean
    fun exportVal(): Any
    fun forEach(action: (a: DataSnapshot) -> dynamic): Boolean
    fun getPriority(): dynamic /* String | Number | Nothing? */
    fun hasChild(path: String): Boolean
    fun hasChildren(): Boolean
    var key: String?
        get() = definedExternally
        set(value) = definedExternally

    fun numChildren(): Number
    fun `val`(): Any
    var ref: Reference
    fun toJSON(): Any?
}

external interface Database {
    var app: App
    fun goOffline(): Any
    fun goOnline(): Any
    fun ref(path: String? = definedExternally): Reference
    fun refFromURL(url: String): Reference
}

external interface OnDisconnect {
    fun cancel(onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
    fun remove(onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
    fun set(value: Any, onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
    fun setWithPriority(
        value: Any,
        priority: Number,
        onComplete: ((a: Error?) -> Any)? = definedExternally
    ): Promise<Any>

    fun setWithPriority(
        value: Any,
        priority: String,
        onComplete: ((a: Error?) -> Any)? = definedExternally
    ): Promise<Any>

    fun setWithPriority(
        value: Any,
        priority: Nothing?,
        onComplete: ((a: Error?) -> Any)? = definedExternally
    ): Promise<Any>

    fun update(values: Any, onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
}

external interface Query {
    fun endAt(value: Number, key: String? = definedExternally): Query
    fun endAt(value: String, key: String? = definedExternally): Query
    fun endAt(value: Boolean, key: String? = definedExternally): Query
    fun endAt(value: Nothing?, key: String? = definedExternally): Query
    fun equalTo(value: Number, key: String? = definedExternally): Query
    fun equalTo(value: String, key: String? = definedExternally): Query
    fun equalTo(value: Boolean, key: String? = definedExternally): Query
    fun equalTo(value: Nothing?, key: String? = definedExternally): Query
    fun isEqual(other: Query?): Boolean
    fun limitToFirst(limit: Number): Query
    fun limitToLast(limit: Number): Query
    fun off(
        eventType: String = definedExternally,
        callback: ((a: DataSnapshot, b: String?) -> Any)? = definedExternally,
        context: Any? = definedExternally
    )

    fun on(
        eventType: String,
        callback: (a: DataSnapshot, b: String?) -> Any,
        cancelCallbackOrContext: Any? = definedExternally,
        context: Any? = definedExternally
    ): (a: DataSnapshot?, b: String?) -> Any

    fun once(
        eventType: String,
        successCallback: ((a: DataSnapshot, b: String?) -> Any)? = definedExternally,
        failureCallbackOrContext: ((a: Error) -> Unit)? = definedExternally,
        context: Any? = definedExternally
    ): Promise<DataSnapshot>

    fun once(
        eventType: String,
        successCallback: ((a: DataSnapshot, b: String?) -> Any)? = definedExternally,
        failureCallbackOrContext: Any? = definedExternally,
        context: Any? = definedExternally
    ): Promise<DataSnapshot>

    fun once(
        eventType: String,
        successCallback: ((a: DataSnapshot, b: String?) -> Any)? = definedExternally,
        failureCallbackOrContext: Nothing? = definedExternally,
        context: Any? = definedExternally
    ): Promise<DataSnapshot>

    fun orderByChild(path: String): Query
    fun orderByKey(): Query
    fun orderByPriority(): Query
    fun orderByValue(): Query
    var ref: Reference
    fun startAt(value: Number, key: String? = definedExternally): Query
    fun startAt(value: String, key: String? = definedExternally): Query
    fun startAt(value: Boolean, key: String? = definedExternally): Query
    fun startAt(value: Nothing?, key: String? = definedExternally): Query
    fun toJSON(): Any
    override fun toString(): String
    fun off()
    fun once(eventType: String): Promise<DataSnapshot>
}

external interface Reference : Query {
    fun child(path: String): Reference
    var key: String?
        get() = definedExternally
        set(value) = definedExternally

    fun onDisconnect(): OnDisconnect
    var parent: Reference?
        get() = definedExternally
        set(value) = definedExternally

    fun push(value: Any? = definedExternally, onComplete: ((a: Error?) -> Any)? = definedExternally): ThenableReference
    fun remove(onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
    var root: Reference
    fun set(value: Any, onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
    fun setPriority(priority: String, onComplete: (a: Error?) -> Any): Promise<Any>
    fun setPriority(priority: Number, onComplete: (a: Error?) -> Any): Promise<Any>
    fun setPriority(priority: Nothing?, onComplete: (a: Error?) -> Any): Promise<Any>
    fun setWithPriority(
        newVal: Any,
        newPriority: String,
        onComplete: ((a: Error?) -> Any)? = definedExternally
    ): Promise<Any>

    fun setWithPriority(
        newVal: Any,
        newPriority: Number,
        onComplete: ((a: Error?) -> Any)? = definedExternally
    ): Promise<Any>

    fun setWithPriority(
        newVal: Any,
        newPriority: Nothing?,
        onComplete: ((a: Error?) -> Any)? = definedExternally
    ): Promise<Any>

    fun transaction(
        transactionUpdate: (a: Any) -> Any,
        onComplete: ((a: Error?, b: Boolean, c: DataSnapshot?) -> Any)? = definedExternally,
        applyLocally: Boolean? = definedExternally
    ): Promise<Any>

    fun update(values: Any, onComplete: ((a: Error?) -> Any)? = definedExternally): Promise<Any>
}

external interface ThenableReference : Reference, Promise<Reference>

external fun enableLogging(logger: Boolean? = definedExternally, persistent: Boolean? = definedExternally): Any

external fun enableLogging(
    logger: ((a: String) -> Any)? = definedExternally,
    persistent: Boolean? = definedExternally
): Any

external fun enableLogging(): Any