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

        val delegate by lazy {
            PlatformSpecificUserProfileChangeRequestBuilder()
        }

        actual fun build() =
            delegate.build().toMpp()

        actual fun setDisplayName(displayName: String?): Builder {
            delegate.setDisplayName(displayName)
            return this
        }

        actual fun setPhotoUri(photoUri: String?): Builder {
            delegate.setPhotoUri(Uri.parse(photoUri))
            return this
        }

    }

}