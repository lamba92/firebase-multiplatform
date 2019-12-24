package com.github.lamba92.firebasemultiplatform.auth

interface UserInfo {

    val delegate: PlatformSpecificUserInfo

    val displayName: String?
    val email: String?
    val phoneNumber: String?
    val photoUrl: String?
    val providerId: String
    val uid: String
    val isEmailVerified: Boolean

}
