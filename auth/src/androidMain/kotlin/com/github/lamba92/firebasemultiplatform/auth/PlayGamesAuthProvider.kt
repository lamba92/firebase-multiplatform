package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.PlayGamesAuthProvider

actual object PlayGamesAuthProvider {

    actual val PLAY_GAMES_SIGN_IN_METHOD: String
        get() = PlayGamesAuthProvider.PLAY_GAMES_SIGN_IN_METHOD
    actual val PROVIDER_ID: String
        get() = PlayGamesAuthProvider.PROVIDER_ID

    actual fun getCredential(serverAuthCode: String) =
        PlayGamesAuthProvider.getCredential(serverAuthCode).toMpp()

}