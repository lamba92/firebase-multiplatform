package com.github.lamba92.firebasemultiplatform.firestore

import com.github.lamba92.firebasemultiplatform.core.FirebaseApp
import com.github.lamba92.firebasemultiplatform.core.await
import com.github.lamba92.firebasemultiplatform.core.awaitUnit
import com.github.lamba92.firebasemultiplatform.core.toMpp

actual class FirebaseFirestore(val delegate: com.google.firebase.firestore.FirebaseFirestore) {

    actual val app: FirebaseApp
        get() = delegate.app.toMpp()

    actual companion object {

        actual val default: FirebaseFirestore
            get() = com.google.firebase.firestore.FirebaseFirestore.getInstance().toMpp()

        actual fun getInstance(app: FirebaseApp) =
            com.google.firebase.firestore.FirebaseFirestore.getInstance(app.delegate).toMpp()

        actual fun setLoggingEnabled(loggingEnabled: Boolean) =
            com.google.firebase.firestore.FirebaseFirestore.setLoggingEnabled(loggingEnabled)

    }

    actual suspend fun enableNetwork() =
        delegate.enableNetwork().awaitUnit()

    actual suspend fun disableNetwork() =
        delegate.disableNetwork().awaitUnit()

    actual suspend fun terminate() =
        delegate.terminate().awaitUnit()

    actual suspend fun clearPersistence() =
        delegate.clearPersistence().awaitUnit()

    actual suspend fun awaitForPendingWrites() =
        delegate.waitForPendingWrites().awaitUnit()

    actual fun collection(collectionPath: String) =
        delegate.collection(collectionPath).toMpp()

    actual fun collectionGroup(collectionId: String) =
        delegate.collectionGroup(collectionId).toMpp()

    actual fun document(documentPath: String) =
        delegate.document(documentPath).toMpp()

    actual fun batch() =
        delegate.batch().toMpp()

    actual suspend fun <T> runTransaction(updateFunction: FirestoreTransaction.() -> T): T =
        delegate.runTransaction { it.toMpp().updateFunction() }
            .await()

    actual fun modifySettings(settings: FirebaseFirestoreSettings) {
        delegate.firestoreSettings = settings.delegate
    }

}