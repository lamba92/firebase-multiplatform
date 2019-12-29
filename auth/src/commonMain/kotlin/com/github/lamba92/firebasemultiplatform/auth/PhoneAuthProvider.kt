package com.github.lamba92.firebasemultiplatform.auth

expect class PhoneAuthProvider {

    companion object {
        fun getCredential(verificationId: String, smsCode: String): PhoneAuthCredential
        fun getInstance(): PhoneAuthProvider
        fun getInstance(firebaseAuth: FirebaseAuth): PhoneAuthProvider
    }

}