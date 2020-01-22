package firebase.performance

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$1`.get(key: String): Number? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$1`.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$2`.get(key: String): String? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$2`.set(key: String, value: String) {
    asDynamic()[key] = value
}