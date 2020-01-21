package com.github.lamba92.firebasemultiplatform.core

import firebase.app.App
import kotlin.js.Json

fun App.toMpp() =
    FirebaseApp(this)

fun <T> Json.toMap(): Map<String, T> {
    val map = mutableMapOf<String, T>()
    val keys = js("Object").keys(this) as Array<String>
    for (key in keys) {
        if (asDynamic().hasOwnProperty(key) as Boolean) {
            @Suppress("UNCHECKED_CAST")
            map[key] = this[key] as T
        }
    }
    return map
}

@Suppress("FunctionName")
fun <V> PrimitiveHashMap(container: dynamic = emptyMap<String, V>()): HashMap<String, V> {
    val m = HashMap<String, V>().asDynamic()
    m.map = container
    val keys = js("Object.keys")
    m.`$size` = keys(container).length
    return m
}