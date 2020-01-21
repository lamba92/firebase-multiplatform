package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.ActionCodeInfo
import firebase.auth.Operations

actual class ActionCodeResult(val delegate: ActionCodeInfo) {

    actual val operation: Int
        get() = delegate.operation.toInt()

    actual companion object {
        actual val PASSWORD_RESET: Int
            get() = Operations.PASSWORD_RESET.toInt()
        actual val VERIFY_EMAIL: Int
            get() = Operations.VERIFY_EMAIL.toInt()
        actual val RECOVER_EMAIL: Int
            get() = Operations.RECOVER_EMAIL.toInt()
        actual val SIGN_IN_WITH_EMAIL_LINK: Int
            get() = Operations.EMAIL_SIGNIN.toInt()
    }

    actual fun getData(dataId: Int) = when (dataId) {
        PASSWORD_RESET, VERIFY_EMAIL, SIGN_IN_WITH_EMAIL_LINK -> delegate.data.email
        RECOVER_EMAIL -> delegate.data.fromEmail
        else -> null
    }

}

