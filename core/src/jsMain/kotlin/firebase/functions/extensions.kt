package firebase.functions

import kotlin.js.Promise

@Suppress("NOTHING_TO_INLINE")
inline operator fun HttpsCallable.invoke(data: Any?) =
    asDynamic()(data) as Promise<HttpsCallableResult>

@Suppress("NOTHING_TO_INLINE")
inline operator fun HttpsCallable.invoke() =
    asDynamic()() as Promise<HttpsCallableResult>