package com.github.lamba92.firebasemultiplatform.auth

actual class PhoneAuthCredential(delegate: firebase.auth.AuthCredential) : AuthCredential(delegate)