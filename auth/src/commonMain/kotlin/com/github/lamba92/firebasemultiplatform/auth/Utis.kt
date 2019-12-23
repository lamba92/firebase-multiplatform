package com.github.lamba92.firebasemultiplatform.auth

fun PlatformSpecificFirebaseAuth.toMpp() =
    FirebaseAuth(this)

fun PlatformSpecificActionCodeResult.toMpp() =
    ActionCodeResult(this)

fun PlatformSpecificFirebaseUser.toMpp() =
    FirebaseUser(this)