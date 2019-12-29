package com.github.lamba92.firebasemultiplatform.auth

expect class UserInfo {

    val displayName: String?
    val email: String?
    val phoneNumber: String?
    val photoUrl: String?
    val providerId: String
    val uid: String
    val isEmailVerified: Boolean

}
