package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRPhoneAuthCredential

actual class PhoneAuthCredential(override val delegate: FIRPhoneAuthCredential) : AuthCredential(delegate)