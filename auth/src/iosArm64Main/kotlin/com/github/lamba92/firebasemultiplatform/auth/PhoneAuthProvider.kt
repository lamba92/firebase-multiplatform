package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRPhoneAuthProvider
import com.google.firebase.FIRPhoneAuthProviderMeta

actual class PhoneAuthProvider(val delegate: FIRPhoneAuthProvider) {

    actual companion object {

        actual fun getCredential(verificationId: String, smsCode: String) =
            FIRPhoneAuthProvider.provider()
                .credentialWithVerificationID(verificationId, smsCode)
                .toMpp()

        actual fun getInstance() =
            FIRPhoneAuthProvider.provider().toMpp()

        actual fun getInstance(firebaseAuth: FirebaseAuth) =
            FIRPhoneAuthProvider.providerWithAuth(firebaseAuth.delegate).toMpp()

    }

}