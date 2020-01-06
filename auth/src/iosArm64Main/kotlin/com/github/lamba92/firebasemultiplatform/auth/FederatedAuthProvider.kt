package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.FIRFederatedAuthProviderProtocol

actual abstract class FederatedAuthProvider(open val delegate: FIRFederatedAuthProviderProtocol)