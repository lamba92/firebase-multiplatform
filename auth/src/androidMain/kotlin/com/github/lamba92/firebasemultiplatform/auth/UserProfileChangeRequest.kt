package com.github.lamba92.firebasemultiplatform.auth

import android.net.Uri

actual class UserProfileChangeRequest(
    val delegate: PlatformSpecificUserProfileChangeRequest
) {

    actual val displayName: String?
        get() = delegate.displayName
    actual val photoUri: String?
        get() = delegate.photoUri?.toString()

    actual class Builder actual constructor() {

        actual fun build() =
            PlatformSpecificUserProfileChangeRequestBuilder().apply {
                setDisplayName(displayName)
                photoUrl?.let { setPhotoUri(Uri.parse(it)) }
            }.build().toMpp()

        actual var displayName: String? = null
        actual var photoUrl: String? = null

    }

}