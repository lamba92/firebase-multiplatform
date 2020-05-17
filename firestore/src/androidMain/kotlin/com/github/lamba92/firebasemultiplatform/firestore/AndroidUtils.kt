package com.github.lamba92.firebasemultiplatform.firestore

import com.google.firebase.firestore.*
import com.google.firebase.firestore.Source

fun com.google.firebase.firestore.FirebaseFirestoreSettings.toMpp() =
    FirebaseFirestoreSettings(this)

fun com.google.firebase.firestore.FirebaseFirestore.toMpp() =
    FirebaseFirestore(this)

fun DocumentReference.toMpp() =
    FirestoreDocumentReference(this)

fun CollectionReference.toMpp() =
    FirestoreCollectionReference(this)

fun Query.toMpp() =
    FirestoreQuery(this)

fun WriteBatch.toMpp() =
    FirestoreWriteBatch(this)

fun Transaction.toMpp() =
    FirestoreTransaction(this)

fun DocumentSnapshot.toMpp() =
    FirestoreDocumentSnapshot(this)

fun SetOptions.toMpp() =
    FirestoreSetOptions(this)

fun com.google.firebase.firestore.FieldPath.toMpp() =
    FirestoreFieldPath(this)

fun QuerySnapshot.toMpp() =
    FirestoreQuerySnapshot(this)

fun SnapshotMetadata.toMpp() =
    FirestoreSnapshotMetadata(this)

fun com.google.firebase.firestore.DocumentChange.toMpp() =
    FirestoreDocumentChange(this)

fun FirestoreDocumentSnapshot.ServerTimestampBehaviour.asNative() = when (this) {
    FirestoreDocumentSnapshot.ServerTimestampBehaviour.ESTIMATE -> DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
    FirestoreDocumentSnapshot.ServerTimestampBehaviour.NONE -> DocumentSnapshot.ServerTimestampBehavior.NONE
    FirestoreDocumentSnapshot.ServerTimestampBehaviour.PREVIOUS -> DocumentSnapshot.ServerTimestampBehavior.PREVIOUS
}

fun Array<out Any>.expelDelegates() =
    map { if (it is FirestoreDocumentSnapshot) it.delegate else it }
        .toTypedArray()

fun FirestoreQuery.Direction.asNative() = when (this) {
    FirestoreQuery.Direction.ASCENDING -> Query.Direction.ASCENDING
    FirestoreQuery.Direction.DESCENDING -> Query.Direction.DESCENDING
}

fun Blob.toMpp() =
    FirestoreBlob(this)

actual typealias FirestoreMetadataChanges = MetadataChanges
actual typealias Source = Source

fun com.google.firebase.firestore.GeoPoint.toMpp() =
    GeoPoint(this)