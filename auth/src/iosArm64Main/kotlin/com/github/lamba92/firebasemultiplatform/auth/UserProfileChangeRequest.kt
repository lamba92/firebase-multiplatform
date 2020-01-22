package com.github.lamba92.firebasemultiplatform.auth

actual data class UserProfileChangeRequest(
    actual val displayName: String?,
    actual val photoUri: String?
) {

    actual class Builder actual constructor() {

        actual fun build() =
            UserProfileChangeRequest(displayName, photoUrl)

        actual var displayName: String? = null
        actual var photoUrl: String? = null


    }

}