package com.github.lamba92.firebasemultiplatform.core

/**
 * The entry point of Firebase SDKs. It holds common configuration
 * and state for Firebase APIs. Most applications don't need to
 * directly interact with FirebaseApp.
 */
actual class FirebaseApp actual constructor(
    actual val delegate: PlatformSpecificFirebaseApp
) {
    actual companion object {

        actual val default: FirebaseApp
            get() = PlatformSpecificFirebaseApp.getInstance().toMpp()

        actual fun getInstance(appName: String) =
            PlatformSpecificFirebaseApp.getInstance(appName).toMpp()

    }

    actual val name: String
        get() = delegate.name

    actual val options: FirebaseOptions
        get() = delegate.options.toMpp()

}