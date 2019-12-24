package com.github.lamba92.firebasemultiplatform.auth

actual abstract class FederatedAuthProvider actual constructor(
    actual open val delegate: PlatformSpecificAuthProvider
)