package com.github.lamba92.firebasemultiplatform.core

import com.google.firebase.FIRApp

/**
 * The entry point of Firebase SDKs. It holds common configuration
 * and state for Firebase APIs. Most applications don't need to
 * directly interact with FirebaseApp.
 */
actual class FirebaseApp(
    val delegate: FIRApp
) {

    actual companion object {
        actual val default: FirebaseApp
            get() = FIRApp.defaultApp()!!.toMpp()

        actual fun getInstance(appName: String) =
            FIRApp.appNamed(appName)!!.toMpp()

        actual fun initializeApp(firebaseOptions: FirebaseOptions): FirebaseApp {
            FIRApp.configureWithOptions(firebaseOptions.delegate)
            return default
        }

        actual fun initializeApp(firebaseOptions: FirebaseOptions, name: String): FirebaseApp {
            FIRApp.configureWithName(name, firebaseOptions.delegate)
            return FIRApp.appNamed(name)!!.toMpp()
        }

    }

    actual val name: String
        get() = delegate.name

    actual val options: FirebaseOptions
        get() = delegate.options.toMpp()

}