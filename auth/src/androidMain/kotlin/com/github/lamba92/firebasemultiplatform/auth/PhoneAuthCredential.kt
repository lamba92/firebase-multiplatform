package com.github.lamba92.firebasemultiplatform.auth

actual class PhoneAuthCredential(
    override val delegate: PlatformSpecificPhoneAuthCredential
) : AuthCredential(delegate) {

    val smsCode: String?
        get() = delegate.smsCode

}