package com.github.lamba92.firebasemultiplatform.firestore

actual class GeoPoint(val delegate: firebase.firestore.GeoPoint) {

    actual val latitude: Double
        get() = delegate.latitude.toDouble()
    actual val longitude: Double
        get() = delegate.longitude.toDouble()

    actual override fun equals(other: Any?) = when (other) {
        is GeoPoint -> delegate.isEqual(other.delegate)
        else -> false
    }

    @ExperimentalUnsignedTypes
    actual override fun hashCode(): Int {
        var temp = latitude.toULong()
        var result = ((temp xor temp).toInt() ushr 32)
        temp = longitude.toULong()
        result = 31 * result + ((temp xor temp).toInt() ushr 32)
        return result
    }

    actual override fun toString() =
        "FirestoreGeoPoint(latitude=$latitude, longitude=$longitude)"

}