package firebase.auth

@JsModule("firebase.auth.ActionCodeInfo")
@JsNonModule
external object Operations {
    val EMAIL_SIGNIN: String
    val PASSWORD_RESET: String
    val RECOVER_EMAIL: String
    val VERIFY_EMAIL: String
}