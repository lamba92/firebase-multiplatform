package com.github.lamba92.firebasemultiplatform.auth

actual data class UserProfileChangeRequest(
    actual val displayName: String?,
    actual val photoUri: String?
) {

    actual class Builder actual constructor() {

        private var delegateDN: String? = null
        private var delegatePU: String? = null

        actual fun build() =
            UserProfileChangeRequest(delegateDN, delegatePU)

        actual fun setDisplayName(displayName: String?): Builder {
            delegateDN = displayName
            return this
        }

        actual fun setPhotoUri(photoUri: String?): Builder {
            delegatePU = photoUri
            return this
        }

    }

}