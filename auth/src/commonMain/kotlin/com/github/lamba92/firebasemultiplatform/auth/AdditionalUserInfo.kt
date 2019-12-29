package com.github.lamba92.firebasemultiplatform.auth

expect class AdditionalUserInfo {

    val profile: Map<String, Any>?
    val providerId: String?
    val username: String?
    val isNewUser: Boolean

}