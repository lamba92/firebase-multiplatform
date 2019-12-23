package com.github.lamba92.firebasemultiplatform.core

fun PlatformSpecificFirebaseApp.toMpp() =
    FirebaseApp(this)

fun PlatformSpecificFirebaseOptions.toMpp() =
    FirebaseOptions(this)