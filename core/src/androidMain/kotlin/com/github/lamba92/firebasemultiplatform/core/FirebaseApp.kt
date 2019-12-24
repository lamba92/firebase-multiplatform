package com.github.lamba92.firebasemultiplatform.core

import android.content.Context

/**
 * The entry point of Firebase SDKs. It holds common configuration
 * and state for Firebase APIs. Most applications don't need to
 * directly interact with FirebaseApp.
 */
actual class FirebaseApp internal actual constructor(
    actual val delegate: PlatformSpecificFirebaseApp
) {
    actual companion object {

        private var context: Context? = null
        private val initializedContext
            get() = context ?: throw IllegalStateException(
                "Please initialize FirebaseApp.context in your " +
                        "Application before calling FirebaseApp.initializeApp()"
            )

        actual val default: FirebaseApp
            get() = PlatformSpecificFirebaseApp.getInstance().toMpp()

        actual fun getInstance(appName: String) =
            PlatformSpecificFirebaseApp.getInstance(appName).toMpp()

        actual fun initializeApp(firebaseOptions: FirebaseOptions) =
            PlatformSpecificFirebaseApp
                .initializeApp(initializedContext, firebaseOptions.delegate)
                .toMpp()

        actual fun initializeApp(
            firebaseOptions: FirebaseOptions,
            name: String
        ) = PlatformSpecificFirebaseApp
            .initializeApp(initializedContext, firebaseOptions.delegate, name)
            .toMpp()

        fun initializeApp(context: Context, firebaseOptions: FirebaseOptions) =
            PlatformSpecificFirebaseApp
                .initializeApp(context, firebaseOptions.delegate)
                .toMpp()

        fun initializeApp(
            context: Context,
            firebaseOptions: FirebaseOptions,
            name: String
        ) = PlatformSpecificFirebaseApp
            .initializeApp(context, firebaseOptions.delegate, name)
            .toMpp()
    }

    actual val name: String
        get() = delegate.name

    actual val options: FirebaseOptions
        get() = delegate.options.toMpp()

}