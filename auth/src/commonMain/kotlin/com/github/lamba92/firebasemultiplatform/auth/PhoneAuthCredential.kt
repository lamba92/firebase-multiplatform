package com.github.lamba92.firebasemultiplatform.auth

expect class PhoneAuthCredential : AuthCredential {
    val smsCode: String?
}