package com.github.lamba92.firebasemultiplatform.firestore

actual class FirebaseFirestoreSettings(val delegate: com.google.firebase.firestore.FirebaseFirestoreSettings) {

    actual val areTimestampsInSnapshotsEnabled: Boolean
        get() = delegate.areTimestampsInSnapshotsEnabled()
    actual val cacheSizeBytes: Long
        get() = delegate.cacheSizeBytes
    actual val host: String
        get() = delegate.host
    actual val isPersistenceEnabled: Boolean
        get() = delegate.isPersistenceEnabled
    actual val isSslEnabled: Boolean
        get() = delegate.isSslEnabled

    actual override fun equals(other: Any?) = when (other) {
        is FirebaseFirestoreSettings -> delegate == other.delegate
        else -> false
    }

    actual override fun hashCode() =
        delegate.hashCode()

    actual override fun toString() =
        delegate.toString()

    actual class Builder actual constructor(original: FirebaseFirestoreSettings?) {

        val delegate = original?.delegate?.let { com.google.firebase.firestore.FirebaseFirestoreSettings.Builder(it) }
            ?: com.google.firebase.firestore.FirebaseFirestoreSettings.Builder()

        actual var cacheSizeBytes: Long
            get() = delegate.cacheSizeBytes
            set(value) {
                delegate.cacheSizeBytes = value
            }
        actual var host: String
            get() = delegate.host
            set(value) {
                delegate.host = value
            }
        actual var isPersistenceEnable: Boolean
            get() = delegate.isPersistenceEnabled
            set(value) {
                delegate.isPersistenceEnabled = value
            }
        actual var isSslEnabled: Boolean
            get() = delegate.isSslEnabled
            set(value) {
                delegate.isSslEnabled = value
            }

        actual fun build() =
            delegate.build().toMpp()

    }

}

