package com.github.lamba92.firebasemultiplatform.core

expect class PlatformSpecificFirebaseApp
expect class PlatformSpecificFirebaseOptions

expect fun PlatformSpecificFirebaseApp.toMpp(): FirebaseApp
expect fun PlatformSpecificFirebaseOptions.toMpp(): FirebaseOptions