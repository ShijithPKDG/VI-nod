package com.vinod.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.vinod.app.data.model.Message
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class ChatRepository {
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun sendMessage(message: Message): Result<Unit> {
        return try {
            val messageId = firestore.collection("messages").document().id
            firestore.collection("messages")
                .document(messageId)
                .set(message.copy(messageId = messageId))
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getMessages(groupId: String): Flow<List<Message>> = callbackFlow {
        val listener = firestore.collection("messages")
            .whereEqualTo("groupId", groupId)
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                val messages = snapshot?.documents?.mapNotNull { 
                    it.toObject(Message::class.java) 
                } ?: emptyList()
                trySend(messages)
            }
        awaitClose { listener.remove() }
    }
}
