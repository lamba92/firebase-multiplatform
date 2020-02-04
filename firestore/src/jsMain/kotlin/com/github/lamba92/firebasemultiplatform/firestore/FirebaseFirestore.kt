package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.toMpp
import firebase.firestore.Firestore
import kotlinx.coroutines.await

actual class FirebaseFirestore(val delegate: Firestore) {

    actual val app: FirebaseApp
        get() = delegate.app.toMpp()


    actual companion object {

        actual val default: FirebaseFirestore
            get() = firebase.firestore().toMpp()

        actual fun setLoggingEnabled(loggingEnabled: Boolean) =
            firebase.firestore.setLogLevel(if (loggingEnabled) "debug" else "silent")

        actual fun getInstance(app: FirebaseApp) =
            firebase.firestore(app.delegate).toMpp()

    }

    actual suspend fun enableNetwork() =
        delegate.enableNetwork().await()

    actual suspend fun disableNetwork() =
        delegate.disableNetwork().await()

    actual suspend fun terminate() =
        delegate.terminate().await()

    actual suspend fun clearPersistence() =
        delegate.clearPersistence().await()

    actual suspend fun awaitForPendingWrites() =
        delegate.waitForPendingWrites().await()

    actual fun collection(collectionPath: String) =
        delegate.collection(collectionPath).toMpp()

    actual fun collectionGroup(collectionId: String) =
        delegate.collectionGroup(collectionId).toMpp()

    actual fun document(documentPath: String): FirestoreDocumentReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun batch(): FirestoreWriteBatch {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual suspend fun <T> runTransaction(updateFunction: FirestoreTransaction.() -> T): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun modifySettings(settings: FirebaseFirestoreSettings) {
    }

}