package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRAdditionalUserInfo

actual class AdditionalUserInfo(val delegate: FIRAdditionalUserInfo) {

    actual val profile: Map<String, Any>?
        get() = delegate.profile?.map { (k, v) -> k!!.toString() to v!! }?.toMap()
    actual val providerId: String?
        get() = delegate.providerID
    actual val username: String?
        get() = delegate.username
    actual val isNewUser: Boolean
        get() = delegate.isNewUser()
}

