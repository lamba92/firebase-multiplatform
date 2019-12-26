package com.github.lamba92.firebasemultiplatform.auth

expect class UserProfileChangeRequest {

    val displayName: String?
    val photoUri: String?

    class Builder() {

        fun build(): UserProfileChangeRequest
        fun setDisplayName(displayName: String?): Builder
        fun setPhotoUri(photoUri: String?): Builder
    }
}
