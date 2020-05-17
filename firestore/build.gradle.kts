import com.github.lamba92.firebasemultiplatform.build.firebase

plugins {
    id("firebase-multiplatform-gradle-plugin")
}

kotlin.sourceSets {

    val firebaseFirestoreAndroidVersion: String by project

    val commonMain by getting {
        dependencies {
            api(project(":core"))
        }
    }

    val androidMain by getting {
        dependencies {
            api(firebase("firestore", firebaseFirestoreAndroidVersion))
        }
    }

}