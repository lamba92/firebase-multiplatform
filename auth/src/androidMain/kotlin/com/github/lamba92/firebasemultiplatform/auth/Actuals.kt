package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.ActionCodeResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

actual typealias PlatformSpecificFirebaseAuth = FirebaseAuth
actual typealias PlatformSpecificAuthResult = AuthResult
actual typealias PlatformSpecificFirebaseUser = FirebaseUser

actual typealias PlatformSpecificActionCodeResult = ActionCodeResult

actual typealias PlatformSpecificAuthCredential = AuthCredential