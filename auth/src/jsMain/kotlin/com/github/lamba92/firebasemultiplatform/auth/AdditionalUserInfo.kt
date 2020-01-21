package com.github.lamba92.firebasemultiplatform.auth

import com.github.lamba92.firebasemultiplatform.core.PrimitiveHashMap
import firebase.auth.AdditionalUserInfo

actual class AdditionalUserInfo(val delegate: AdditionalUserInfo) {

    actual val profile: Map<String, Any>?
        get() = delegate.profile?.let { PrimitiveHashMap(it.asDynamic()) }

    actual val providerId: String?
        get() = delegate.providerId

    actual val username: String?
        get() = delegate.username

    actual val isNewUser: Boolean
        get() = delegate.isNewUser

}