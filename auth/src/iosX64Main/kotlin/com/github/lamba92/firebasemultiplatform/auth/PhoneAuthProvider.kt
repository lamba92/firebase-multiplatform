package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRPhoneAuthProvider
import com.google.firebase.FIRPhoneAuthProviderMeta

actual class PhoneAuthProvider(val delegate: FIRPhoneAuthProvider) {

    actual companion object {

        actual fun getCredential(verificationId: String, smsCode: String) =
            object : FIRPhoneAuthProviderMeta() {}.provider().credentialWithVerificationID(
                verificationId,
                smsCode
            ).toMpp()

        actual fun getInstance() =
            object : FIRPhoneAuthProviderMeta() {}.provider().toMpp()

        actual fun getInstance(firebaseAuth: FirebaseAuth) =
            object : FIRPhoneAuthProviderMeta() {}.providerWithAuth(firebaseAuth.delegate).toMpp()

    }

}