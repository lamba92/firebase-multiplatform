package com.github.lamba92.firebasemultiplatform.auth

expect abstract class FederatedAuthProvider(
    delegate: PlatformSpecificAuthProvider
) {
    open val delegate: PlatformSpecificAuthProvider
}