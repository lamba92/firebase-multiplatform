package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.*

fun com.google.firebase.firestore.FirebaseFirestoreSettings.toMpp() =
    FirebaseFirestoreSettings(this)

fun com.google.firebase.firestore.FirebaseFirestore.toMpp() =
    FirebaseFirestore(this)

fun DocumentReference.toMpp() =
    FirebaseDocumentReference(this)

fun CollectionReference.toMpp() =
    FirebaseCollectionReference(this)

fun Query.toMpp() =
    FirebaseQuery(this)

fun WriteBatch.toMpp() =
    FirebaseWriteBatch(this)

fun Transaction.toMpp() =
    FirebaseTransaction(this)

fun DocumentSnapshot.toMpp() =
    FirebaseDocumentSnapshot(this)

fun SetOptions.toMpp() =
    FirebaseSetOptions(this)

fun com.google.firebase.firestore.FieldPath.toMpp() =
    FieldPath(this)

fun QuerySnapshot.toMpp() =
    FirebaseQuerySnapshot(this)

fun SnapshotMetadata.toMpp() =
    FirebaseSnapshotMetadata(this)

fun com.google.firebase.firestore.DocumentChange.toMpp() =
    DocumentChange(this)

fun FirebaseDocumentSnapshot.ServerTimestampBehaviour.asNative() = when (this) {
    FirebaseDocumentSnapshot.ServerTimestampBehaviour.ESTIMATE -> DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
    FirebaseDocumentSnapshot.ServerTimestampBehaviour.NONE -> DocumentSnapshot.ServerTimestampBehavior.NONE
    FirebaseDocumentSnapshot.ServerTimestampBehaviour.PREVIOUS -> DocumentSnapshot.ServerTimestampBehavior.PREVIOUS
}

fun Array<out Any>.expelDelegates() =
    map { if (it is FirebaseDocumentSnapshot) it.delegate else it }
        .toTypedArray()

fun FirebaseQuery.Direction.asNative() = when (this) {
    FirebaseQuery.Direction.ASCENDING -> Query.Direction.ASCENDING
    FirebaseQuery.Direction.DESCENDING -> Query.Direction.DESCENDING
}

fun Blob.toMpp() =
    FirebaseBlob(this)