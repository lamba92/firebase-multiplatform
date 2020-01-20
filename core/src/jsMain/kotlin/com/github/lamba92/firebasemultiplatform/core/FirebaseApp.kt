package com.github.lamba92.firebasemultiplatform.core

import firebase.app
import firebase.app.App

/**
 * The entry point of Firebase SDKs. It holds common configuration
 * and state for Firebase APIs. Most applications don't need to
 * directly interact with FirebaseApp.
 */
actual class FirebaseApp(val delegate: App) {

    actual companion object {

        actual val default: FirebaseApp
            get() = app().toMpp()

        actual fun getInstance(appName: String) =
            app(appName).toMpp()

        actual fun initializeApp(firebaseOptions: FirebaseOptions) =
            firebase.initializeApp(firebaseOptions).toMpp()

        actual fun initializeApp(firebaseOptions: FirebaseOptions, name: String) =
            firebase.initializeApp(firebaseOptions, name).toMpp()
    }

    actual val name: String
        get() = delegate.name

    actual val options: FirebaseOptions
        get() = delegate.options as FirebaseOptions

}
