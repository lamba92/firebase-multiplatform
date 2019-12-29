package com.github.lamba92.firebasemultiplatform.auth

expect class ActionCodeResult {

    val operation: Int

    companion object {
        val PASSWORD_RESET: Int
        val VERIFY_EMAIL: Int
        val RECOVER_EMAIL: Int
        val ERROR: Int
        val SIGN_IN_WITH_EMAIL_LINK: Int
        val EMAIL: Int
        val FROM_EMAIL: Int
    }

    fun getData(dataId: Int): String?

}