package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.Blob
import org.khronos.webgl.Uint8Array
import org.khronos.webgl.get
import kotlin.experimental.and
import kotlin.math.min

actual class FirestoreBlob(val delegate: Blob) : Comparable<FirestoreBlob> {

    actual val bytes: ByteArray
        get() = with(delegate.toUint8Array()) {
            ByteArray(length) { get(it) }
        }

    actual companion object {
        actual fun fromBytes(bytes: ByteArray) =
            Blob.fromUint8Array(Uint8Array(bytes.toTypedArray())).toMpp()
    }

    actual override fun equals(other: Any?) = when (other) {
        is FirestoreBlob -> delegate.isEqual(other.delegate)
        else -> false
    }

    actual override fun hashCode() =
        delegate.toBase64().hashCode()

    actual override fun toString() =
        super.toString()

    override fun compareTo(other: FirestoreBlob): Int {

        // copied from JVm implementation https://bit.ly/394kwHG
        val size: Int = min(bytes.size, other.bytes.size)

        for (i in 0 until size) {
            val thisByte = bytes[i] and 255.toByte()
            val otherByte = other.bytes[i] and 255.toByte()
            if (thisByte < otherByte) {
                return -1
            }
            if (thisByte > otherByte) {
                return 1
            }
        }

        return bytes.size.compareTo(other.bytes.size)
    }

}