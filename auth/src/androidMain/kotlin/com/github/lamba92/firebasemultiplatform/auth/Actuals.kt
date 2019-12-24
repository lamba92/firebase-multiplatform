package com.github.lamba92.firebasemultiplatform.auth

import com.google.firebase.auth.*
import com.google.firebase.auth.ActionCodeResult
import com.google.firebase.auth.AdditionalUserInfo
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FederatedAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseUserMetadata
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.UserInfo
import com.google.firebase.auth.UserProfileChangeRequest

actual typealias PlatformSpecificFirebaseAuth = FirebaseAuth
actual typealias PlatformSpecificAuthResult = AuthResult
actual typealias PlatformSpecificFirebaseUser = FirebaseUser
actual typealias PlatformSpecificAuthCredential = AuthCredential
actual typealias PlatformSpecificActionCodeResult = ActionCodeResult
actual typealias PlatformSpecificGetTokenResults = GetTokenResult
actual typealias PlatformSpecificFirebaseUserMetadata = FirebaseUserMetadata
actual typealias PlatformSpecificUserInfo = UserInfo
actual typealias PlatformSpecificUserProfileChangeRequest = UserProfileChangeRequest
actual typealias PlatformSpecificUserProfileChangeRequestBuilder = UserProfileChangeRequest.Builder
actual typealias PlatformSpecificPhoneAuthProvider = PhoneAuthProvider
actual typealias PlatformSpecificPhoneAuthCredential = PhoneAuthCredential
actual typealias PlatformSpecificAdditionalUserInfo = AdditionalUserInfo
actual typealias PlatformSpecificGithubAuthCredential = GithubAuthCredential
actual typealias PlatformSpecificAuthProvider = FederatedAuthProvider
actual typealias PlatformSpecificOAuthProvider = OAuthProvider
actual typealias PlatformSpecificOAuthProviderBuilder = OAuthProvider.Builder
actual typealias PlatformSpecificOAuthProviderCredentialsBuilder = OAuthProvider.CredentialBuilder