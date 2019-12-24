package com.github.lamba92.firebasemultiplatform.auth

actual fun PlatformSpecificActionCodeResult.toMpp() =
    object : ActionCodeResult {
        override val delegate: PlatformSpecificActionCodeResult
            get() = this@toMpp
        override val operation: Int
            get() = delegate.operation

        override fun getData(dataId: Int) =
            delegate.getData(dataId)
    }

actual fun PlatformSpecificAuthResult.toMpp() =
    object : AuthResult {
        override val delegate: PlatformSpecificAuthResult
            get() = this@toMpp
        override val additionalUserInfo: AdditionalUserInfo?
            get() = delegate.additionalUserInfo?.toMpp()
        override val credentials: AuthCredential?
            get() = delegate.credential?.toMpp()
        override val user: FirebaseUser?
            get() = delegate.user?.toMpp()
    }

actual fun PlatformSpecificFirebaseUserMetadata.toMpp() =
    object : FirebaseUserMetadata {
        override val delegate: PlatformSpecificFirebaseUserMetadata
            get() = this@toMpp
        override val creationTimestamp: Long
            get() = delegate.creationTimestamp
        override val lastSignInTimestamp: Long
            get() = delegate.lastSignInTimestamp
    }

actual fun PlatformSpecificUserInfo.toMpp() =
    object : UserInfo {
        override val delegate: PlatformSpecificUserInfo
            get() = this@toMpp
        override val displayName: String?
            get() = delegate.displayName
        override val email: String?
            get() = delegate.email
        override val phoneNumber: String?
            get() = delegate.phoneNumber
        override val photoUrl: String?
            get() = delegate.photoUrl?.toString()
        override val providerId: String
            get() = delegate.providerId
        override val uid: String
            get() = delegate.uid
        override val isEmailVerified: Boolean
            get() = delegate.isEmailVerified
    }

actual fun PlatformSpecificAdditionalUserInfo.toMpp() =
    object : AdditionalUserInfo {
        override val delegate: PlatformSpecificAdditionalUserInfo
            get() = this@toMpp
        override val profile: Map<String, Any>?
            get() = delegate.profile
        override val providerId: String?
            get() = delegate.providerId
        override val username: String?
            get() = delegate.username
        override val isNewUser: Boolean
            get() = delegate.isNewUser
    }