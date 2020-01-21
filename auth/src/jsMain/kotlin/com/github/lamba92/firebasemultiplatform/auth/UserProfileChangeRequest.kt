package com.github.lamba92.firebasemultiplatform.auth

import firebase.`T$0`

actual class UserProfileChangeRequest(val delegate: `T$0`) {

    actual val displayName: String?
        get() = delegate.displayName
    actual val photoUri: String?
        get() = delegate.photoURL

    actual class Builder actual constructor() {

        actual fun build() = UserProfileChangeRequest(object : `T$0` {
            override var displayName = this@Builder.displayName
            override var photoURL = this@Builder.photoUrl
        })

        actual var displayName: String? = null
        actual var photoUrl: String? = null

    }

}