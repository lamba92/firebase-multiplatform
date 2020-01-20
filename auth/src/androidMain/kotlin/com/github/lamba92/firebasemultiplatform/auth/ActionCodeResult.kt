@file:Suppress("unused")

package com.github.lamba92.firebasemultiplatform.auth

actual class ActionCodeResult(
    val delegate: PlatformSpecificActionCodeResult
) {

    actual val operation: Int
        get() = delegate.operation

    actual companion object {
        actual val PASSWORD_RESET = PlatformSpecificActionCodeResult.PASSWORD_RESET
        actual val VERIFY_EMAIL = PlatformSpecificActionCodeResult.VERIFY_EMAIL
        actual val RECOVER_EMAIL = PlatformSpecificActionCodeResult.RECOVER_EMAIL
        val ERROR = PlatformSpecificActionCodeResult.ERROR
        actual val SIGN_IN_WITH_EMAIL_LINK = PlatformSpecificActionCodeResult.SIGN_IN_WITH_EMAIL_LINK
        val EMAIL = PlatformSpecificActionCodeResult.EMAIL
        val FROM_EMAIL = PlatformSpecificActionCodeResult.FROM_EMAIL
    }

    actual fun getData(dataId: Int) =
        delegate.getData(dataId)

}