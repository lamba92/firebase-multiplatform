@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

external interface IteratorResult<T> {
    var done: Boolean
    var value: T
}

external interface TsStdLib_Iterator<T> {
    fun next(value: Any? = definedExternally): IteratorResult<T>
    val `return`: ((value: Any? /* = null */) -> IteratorResult<T>)?
        get() = definedExternally
    val `throw`: ((e: Any? /* = null */) -> IteratorResult<T>)?
        get() = definedExternally
}

external interface IterableIterator<T> : TsStdLib_Iterator<T>