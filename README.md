# Firebase wrappers for Kotlin Multiplatform [ ![Download](https://api.bintray.com/packages/lamba92/com.github.lamba92/firebase-multiplatform/images/download.svg) ](https://bintray.com/lamba92/com.github.lamba92/firebase-multiplatform/_latestVersion) [![Build Status](https://travis-ci.org/lamba92/firebase-multiplatform.svg?branch=master)](https://travis-ci.org/lamba92/firebase-multiplatform)
Kotlin Multiplatform is great, Firebase is great, why not use them togheter?

This library aims to bridge the common Firebase APIs in different platforms so that it is possible to use them in Kotlin Multiplatform!

All APIs look and feel will try to stay faithful to the Android version as much as possible since Kotlin has been created mostly with Java into account. As consequence of that, until a proper documentation is available use the official Firebase Android/Java documentation

## How it works
Each class or interface has a platform specific delegate that is actually doing all the stuff inside the object. You can always access this delegate but only when ia a specific platform sources you will be able to see it's method.

## Platforms
Since Firebase has many platforms and services, covering them all by myself is kind of hard, especially for the Objective-C one. I will list the ones that i want to support by myself, but pull requests are welcome! 
 - Android:
   - core ✅
   - auth ✅
   - storage ✅
     - storage-mobile **[IN PROGRESS]**
   - firestore **[TODO]**
 - JS web client:
   - core ✅ (probably bugged)
   - auth ✅ (probably bugged)
   - storage ✅ (probably bugged)
   - firestore **[TODO]**
 - iOS:
    - core ✅
    - auth ✅
    - storage ✅
      - storage-mobile **[IN PROGRESS]**
    - firestore **[TODO]**
   
## Some examples
[`FirebaseApp`](https://github.com/lamba92/firebase-multiplatform/blob/master/core/src/commonMain/kotlin/com/github/lamba92/firebasemultiplatform/core/FirebaseApp.kt) initialization:
```kotlin
// common sources
val fApp: FirebaseApp = FirebaseApp.initializeApp {
    setApiKey("mkey")
    setApplicationId("mAppId")
    setDatabaseUrl("dbUrl")
    setProjectId("projectId")
    setStorageBucket("bucket")
    setGcmSenderId("i have no idea what this is")
}
```
[`FirebaseAuth`](https://github.com/lamba92/firebase-multiplatform/blob/master/auth/src/commonMain/kotlin/com/github/lamba92/firebasemultiplatform/auth/FirebaseAuth.kt) initialization and auth changes:
```kotlin
// get the default firebase auth 
// instance and listen to auth changes
// in global scope
val job = FirebaseAuth.default.authStateFlow
    // this will be executed in main thread 
    // as the official documentation states!        
    .onEach { isLoggedIn -> /*do stuff*/ }
    .launchIn(GlobalScope)
    
    // stop listening and detach listener
    job.cancel()
```

## Install [ ![Download](https://api.bintray.com/packages/lamba92/com.github.lamba92/firebase-multiplatform/images/download.svg) ](https://bintray.com/lamba92/com.github.lamba92/firebase-multiplatform/_latestVersion)
Packages are available at my Bintray repo:
```kotlin
repositories {
    maven("https://dl.bintray.com/lamba92/com.github.lamba92")
}
```
Someday I will setup the sign of the packes so that they will be mirrored to Maven Central Repository, but today is not that day!

Add in common sources:
```kotlin
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.github.lamba92:firebase-multiplatform-core:0.0.2")
                implementation("com.github.lamba92:firebase-multiplatform-auth:0.0.2")
            }
        }    
    }
}
```
