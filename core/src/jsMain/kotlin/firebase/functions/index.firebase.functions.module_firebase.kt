@file:JsQualifier("firebase.functions")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.functions

external interface HttpsCallableResult {
    var data: Any
}

external interface HttpsCallable

external interface HttpsCallableOptions {
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

open external class Functions {
    open fun useFunctionsEmulator(url: String)
    open fun httpsCallable(name: String, options: HttpsCallableOptions? = definedExternally): HttpsCallable
}