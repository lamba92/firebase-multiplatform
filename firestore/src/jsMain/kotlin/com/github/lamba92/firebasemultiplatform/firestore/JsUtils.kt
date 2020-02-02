package com.github.lamba92.firebasemultiplatform.firestore

import firebase.firestore.*

fun Firestore.toMpp() =
    FirebaseFirestore(this)

fun DocumentReference<DocumentData>.toMpp() =
    FirestoreDocumentReference(this)

fun CollectionReference<DocumentData>.toMpp() =
    FirestoreCollectionReference(this)

fun DocumentSnapshot<DocumentData>.toMpp() =
    FirestoreDocumentSnapshot(this)

fun SnapshotMetadata.toMpp() =
    FirestoreSnapshotMetadata(this)

fun FieldPath.toMpp() =
    FirestoreFieldPath(this)