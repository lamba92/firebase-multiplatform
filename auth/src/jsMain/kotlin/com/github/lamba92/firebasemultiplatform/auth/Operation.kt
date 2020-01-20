package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.Operation

@JsModule("firebase.auth.ActionCodeInfo")
@JsNonModule
external object Operation {
    val EMAIL_SIGNIN: Operation
    val PASSWORD_RESET: Operation
    val RECOVER_EMAIL: Operation
    val VERIFY_EMAIL: Operation
}