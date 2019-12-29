package com.github.lamba92.firebasemultiplatform.auth

expect object PlayGamesAuthProvider {
    val PLAY_GAMES_SIGN_IN_METHOD: String
    val PROVIDER_ID: String

    fun getCredential(serverAuthCode: String): AuthCredential
}