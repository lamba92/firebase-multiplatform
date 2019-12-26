package com.github.lamba92.firebasemultiplatform.auth

actual class PhoneAuthProvider(
    val delegate: PlatformSpecificPhoneAuthProvider
) {

    actual companion object {
        actual fun getCredential(
            verificationId: String,
            smsCode: String
        ) = PlatformSpecificPhoneAuthProvider
            .getCredential(verificationId, smsCode)
            .toMpp()

        actual fun getInstance() =
            PlatformSpecificPhoneAuthProvider.getInstance().toMpp()

        actual fun getInstance(firebaseAuth: FirebaseAuth) =
            PlatformSpecificPhoneAuthProvider.getInstance(firebaseAuth.delegate).toMpp()
    }

}