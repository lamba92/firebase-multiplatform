package com.github.lamba92.firebasemultiplatform.auth

expect class UserProfileChangeRequest(
    delegate: PlatformSpecificUserProfileChangeRequest
) {

    val delegate: PlatformSpecificUserProfileChangeRequest
    val displayName: String?
    val photoUri: String?

    class Builder() {

        val delegate: PlatformSpecificUserProfileChangeRequestBuilder

        fun build(): UserProfileChangeRequest
        fun setDisplayName(displayName: String?): Builder
        fun setPhotoUri(photoUri: String?): Builder
    }
}
