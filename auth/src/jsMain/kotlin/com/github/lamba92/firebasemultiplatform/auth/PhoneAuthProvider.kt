package com.github.lamba92.firebasemultiplatform.auth

actual class PhoneAuthProvider(val delegate: firebase.auth.PhoneAuthProvider_Instance) {

    actual companion object {
        actual fun getCredential(verificationId: String, smsCode: String) =
            PhoneAuthCredential(firebase.auth.PhoneAuthProvider.credential(verificationId, smsCode))

        actual fun getInstance() =
            firebase.auth.PhoneAuthProvider().toMpp()

        actual fun getInstance(firebaseAuth: FirebaseAuth) =
            firebase.auth.PhoneAuthProvider_Instance(firebaseAuth.delegate).toMpp()
    }

}