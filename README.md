# Firebase wrappers for Kotlin Multiplatform
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
   - storage **[TODO]**
   - firestore **[TODO]**
 - JS web client:
   - core **[TODO]**
   - auth **[TODO]**
   - storage **[TODO]**
   - firestore **[TODO]**
   
## Some examples
[`FirebaseApp`]() initialization:
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
[`FirebaseAuth`]() initialization and auth changes:
```kotlin
// get the default firebase auth 
    // instance and listen to auth changes
    // in global scope
    val job = FirebaseAuth.default.authStateFlow
        // this will be executed in main thread 
        // as the official documentation states!        
        .onEach { isLoggedin -> /*do stuff*/ }
        .launchIn(GlobalScope)
    
    // stop listening and detach listener
    job.cancel()
```
