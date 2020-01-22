@file:JsQualifier("firebase.performance")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.performance

external interface Performance {
    fun trace(traceName: String): Trace
    var instrumentationEnabled: Boolean
    var dataCollectionEnabled: Boolean
}

external interface `T$1`

external interface `T$2`

external interface `T$3` {
    var metrics: `T$1`?
        get() = definedExternally
        set(value) = definedExternally
    var attributes: `T$2`?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Trace {
    fun start()
    fun stop()
    fun record(startTime: Number, duration: Number, options: `T$3`? = definedExternally)
    fun incrementMetric(metricName: String, num: Number? = definedExternally)
    fun putMetric(metricName: String, num: Number)
    fun getMetric(metricName: String): Number
    fun putAttribute(attr: String, value: String)
    fun getAttribute(attr: String): String?
    fun removeAttribute(attr: String)
    fun getAttributes(): `T$2`
}