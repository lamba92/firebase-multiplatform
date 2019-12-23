package com.github.lamba92.firebasemultiplatform.auth

expect class PhoneAuthCredential(
    delegate: PlatformSpecificPhoneAuthCredential
) : AuthCredential {
    override val delegate: PlatformSpecificPhoneAuthCredential
    val smsCode: String?
}