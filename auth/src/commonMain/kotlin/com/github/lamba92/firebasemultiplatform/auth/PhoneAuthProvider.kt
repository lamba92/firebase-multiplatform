package com.github.lamba92.firebasemultiplatform.auth

expect class PhoneAuthProvider(
    delegate: PlatformSpecificPhoneAuthProvider
) {
    val delegate: PlatformSpecificPhoneAuthProvider

    companion object {
        fun getCredential(verificationId: String, smsCode: String): PhoneAuthCredential
        fun getInstance(): PhoneAuthProvider
        fun getInstance(firebaseAuth: FirebaseAuth): PhoneAuthProvider
    }

}