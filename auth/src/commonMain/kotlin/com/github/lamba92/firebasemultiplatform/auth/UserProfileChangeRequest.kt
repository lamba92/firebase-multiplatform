package com.github.lamba92.firebasemultiplatform.auth

expect class UserProfileChangeRequest {

    val displayName: String?
    val photoUri: String?

    class Builder() {

        var displayName: String?
        var photoUrl: String?

        fun build(): UserProfileChangeRequest

    }
}
