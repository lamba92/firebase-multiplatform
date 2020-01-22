package firebase.remoteConfig

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$4`.get(key: String): dynamic /* String | Number | Boolean */ = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$4`.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$4`.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$4`.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$5`.get(key: String): Value? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun `T$5`.set(key: String, value: Value) {
    asDynamic()[key] = value
}