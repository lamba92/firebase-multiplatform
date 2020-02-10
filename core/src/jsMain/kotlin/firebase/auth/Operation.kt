@file:JsModule("firebase")
@file:JsQualifier("auth.ActionCodeInfo")
@file:JsNonModule

package firebase.auth

external object Operations {
    val EMAIL_SIGNIN: String
    val PASSWORD_RESET: String
    val RECOVER_EMAIL: String
    val VERIFY_EMAIL: String
}
