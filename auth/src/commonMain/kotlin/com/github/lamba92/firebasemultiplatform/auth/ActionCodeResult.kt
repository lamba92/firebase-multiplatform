package com.github.lamba92.firebasemultiplatform.auth

expect class ActionCodeResult {

    val operation: Int

    companion object {
        val PASSWORD_RESET: Int
        val VERIFY_EMAIL: Int
        val RECOVER_EMAIL: Int
        val SIGN_IN_WITH_EMAIL_LINK: Int
    }

    fun getData(dataId: Int): String?

}