package com.github.lamba92.firebasemultiplatform.core

import firebase.app.App

fun App.toMpp() =
    FirebaseApp(this)