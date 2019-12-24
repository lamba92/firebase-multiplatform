package com.github.lamba92.firebasemultiplatform.auth

interface AdditionalUserInfo {

    val delegate: PlatformSpecificAdditionalUserInfo

    val profile: Map<String, Any>?
    val providerId: String?
    val username: String?
    val isNewUser: Boolean
}