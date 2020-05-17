package com.github.lamba92.firebasemultiplatform.firestore

actual class GeoPoint(val delegate: com.google.firebase.firestore.GeoPoint) {

    actual val latitude: Double
        get() = delegate.latitude

    actual val longitude: Double
        get() = delegate.longitude

    actual override fun equals(other: Any?) = when (other) {
        is GeoPoint -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual override fun toString() =
        delegate.toString()

}