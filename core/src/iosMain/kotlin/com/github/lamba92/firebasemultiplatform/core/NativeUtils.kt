package com.github.lamba92.firebasemultiplatform.core

import com.google.firebase.FIRApp
import com.google.firebase.FIROptions

fun FIRApp.toMpp() =
    FirebaseApp(this)

fun FIROptions.toMpp() =
    FirebaseOptions(this)