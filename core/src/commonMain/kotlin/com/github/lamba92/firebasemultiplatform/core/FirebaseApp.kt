package com.github.lamba92.firebasemultiplatform.core

/**
 * The entry point of Firebase SDKs. It holds common configuration
 * and state for Firebase APIs. Most applications don't need to
 * directly interact with FirebaseApp.
 */
expect class FirebaseApp internal constructor(
    delegate: PlatformSpecificFirebaseApp
) {

    val delegate: PlatformSpecificFirebaseApp

    companion object {
        val default: FirebaseApp
        fun getInstance(appName: String): FirebaseApp
        fun initializeApp(firebaseOptions: FirebaseOptions): FirebaseApp
        fun initializeApp(firebaseOptions: FirebaseOptions, name: String): FirebaseApp
    }

    val name: String

    val options: FirebaseOptions

}