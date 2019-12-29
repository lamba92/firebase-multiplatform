package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.*

actual class ActionCodeResult(
    val delegate: FIRActionCodeInfo
) {

    actual val operation: Int
        get() = delegate.operation.toInt()

    actual companion object {
        actual val PASSWORD_RESET: Int
            get() = FIRActionCodeOperationPasswordReset.toInt()
        actual val VERIFY_EMAIL: Int
            get() = FIRActionCodeOperationVerifyEmail.toInt()
        actual val RECOVER_EMAIL: Int
            get() = FIRActionCodeOperationRecoverEmail.toInt()
        actual val ERROR: Int
            get() = FIRActionCodeOperationUnknown.toInt()
        actual val SIGN_IN_WITH_EMAIL_LINK: Int
            get() = FIRActionCodeOperationEmailLink.toInt()
        actual val EMAIL: Int
            get() = FIRActionCodeEmailKey.toInt()
        actual val FROM_EMAIL: Int
            get() = FIRActionCodeFromEmailKey.toInt()
    }

    actual fun getData(dataId: Int): String? =
        delegate.dataForKey(dataId.toLong())

}