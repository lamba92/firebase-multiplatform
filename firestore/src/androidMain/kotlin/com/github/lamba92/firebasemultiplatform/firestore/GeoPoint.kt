package com.github.lamba92.firebasemultiplatform.firestore

actual class GeoPoint(val delegate: com.google.firebase.firestore.GeoPoint) : Comparable<GeoPoint> {

    actual val latitude: Double
        get() = delegate.latitude

    actual val longitude: Double
        get() = delegate.longitude

    actual override fun equals(other: Any?) =
        delegate.actual override fun hashCode(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    actual override fun toString(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun compareTo(other: GeoPoint): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}