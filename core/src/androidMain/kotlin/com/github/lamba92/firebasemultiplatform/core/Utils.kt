package com.github.lamba92.firebasemultiplatform.core

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> Task<T>.await() = suspendCancellableCoroutine<T> { cont ->
    addOnSuccessListener { cont.resume(it) }
        .addOnCanceledListener { cont.cancel() }
        .addOnFailureListener { cont.resumeWithException(it) }
}

suspend fun Task<Void>.awaitUnit() {
    await()
}