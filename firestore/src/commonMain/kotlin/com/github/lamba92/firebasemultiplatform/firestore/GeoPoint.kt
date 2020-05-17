package com.github.lamba92.firebasemultiplatform.firestore

expect class GeoPoint {

    val latitude: Double
    val longitude: Double

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
