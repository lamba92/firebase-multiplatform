package com.github.lamba92.firebasemultiplatform.core

import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

actual typealias PlatformSpecificFirebaseOptions = FirebaseOptions
actual typealias PlatformSpecificFirebaseApp = FirebaseApp

actual fun PlatformSpecificFirebaseApp.toMpp() =
    FirebaseApp(this)

actual fun PlatformSpecificFirebaseOptions.toMpp() =
    FirebaseOptions(this)