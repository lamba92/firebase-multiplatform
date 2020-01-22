package firebase.firestore

@Suppress("NOTHING_TO_INLINE")
inline operator fun DocumentData.get(field: String): Any? = asDynamic()[field]

@Suppress("NOTHING_TO_INLINE")
inline operator fun DocumentData.set(field: String, value: Any) {
    asDynamic()[field] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun UpdateData.get(fieldPath: String): Any? = asDynamic()[fieldPath]

@Suppress("NOTHING_TO_INLINE")
inline operator fun UpdateData.set(fieldPath: String, value: Any) {
    asDynamic()[fieldPath] = value
}