package com.github.lamba92.firebasemultiplatform.auth

actual class PhoneAuthCredential actual constructor(
    actual override val delegate: PlatformSpecificPhoneAuthCredential
) : AuthCredential(delegate) {

    actual val smsCode: String?
        get() = delegate.smsCode

}