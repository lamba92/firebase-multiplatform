package com.github.lamba92.firebasemultiplatform.auth

actual abstract class FederatedAuthProvider(
    open val delegate: PlatformSpecificAuthProvider
)