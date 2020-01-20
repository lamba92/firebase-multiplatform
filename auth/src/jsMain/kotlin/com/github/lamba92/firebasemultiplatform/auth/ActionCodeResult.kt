package com.github.lamba92.firebasemultiplatform.auth

import firebase.auth.ActionCodeInfo

actual class ActionCodeResult(val delegate: ActionCodeInfo) {

    actual val operation: Int
        get() = delegate.operation.toInt()

    actual companion object {
        actual val PASSWORD_RESET: Int
            get() = Operation.PASSWORD_RESET.toInt()
        actual val VERIFY_EMAIL: Int
            get() = Operation.VERIFY_EMAIL.toInt()
        actual val RECOVER_EMAIL: Int
            get() = Operation.RECOVER_EMAIL.toInt()
        actual val SIGN_IN_WITH_EMAIL_LINK: Int
            get() = Operation.EMAIL_SIGNIN.toInt()
    }

    actual fun getData(dataId: Int) = when (dataId) {
        PASSWORD_RESET, VERIFY_EMAIL, SIGN_IN_WITH_EMAIL_LINK -> delegate.data.email
        RECOVER_EMAIL -> delegate.data.fromEmail
        else -> null
    }

}

