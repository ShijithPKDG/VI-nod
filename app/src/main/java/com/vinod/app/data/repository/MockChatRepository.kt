package com.vinod.app.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vinod.app.data.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MockChatRepository(private val context: Context) {
    
    private val prefs = context.getSharedPreferences("mock_messages", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val messagesFlow = MutableStateFlow<List<Message>>(emptyList())
    
    private fun saveMessages(messages: List<Message>) {
        val json = gson.toJson(messages)
        prefs.edit().putString("messages", json).apply()
        messagesFlow.value = messages
    }
    
    private fun loadMessages(): MutableList<Message> {
        val json = prefs.getString("messages", null) ?: return mutableListOf()
        val type = object : TypeToken<MutableList<Message>>() {}.type
        return gson.fromJson(json, type) ?: mutableListOf()
    }
    
    fun sendMessage(message: Message): Result<Unit> {
        val messages = loadMessages()
        val newMessage = message.copy(
            messageId = "msg_${System.currentTimeMillis()}",
            timestamp = System.currentTimeMillis()
        )
        messages.add(newMessage)
        saveMessages(messages)
        return Result.success(Unit)
    }
    
    fun getMessages(groupId: String): Flow<List<Message>> {
        var messages = loadMessages().filter { it.groupId == groupId }.toMutableList()
        
        // Add demo messages if group is empty
        if (messages.isEmpty()) {
            val demoNames = listOf(
                "Pookie Vyshnav", "Gym Pranav", "Vinod", "Shijith", 
                "Akhil", "Appos", "Bhuvanesh", "Navaneeth", 
                "Nived", "Thejus", "Pooran"
            )
            val demoMessages = listOf(
                "Hey everyone! 👋",
                "Welcome to the group!",
                "This is awesome! 🎉",
                "Let's stay connected",
                "Great to be here!",
                "Hello friends! 😊",
                "Nice to meet you all",
                "Looking forward to chatting",
                "This app is cool!",
                "Hi there! 👍",
                "Excited to be part of this group"
            )
            
            demoNames.forEachIndexed { index, name ->
                messages.add(Message(
                    messageId = "demo_$index",
                    groupId = groupId,
                    senderId = "demo_user_$index",
                    senderName = name,
                    text = demoMessages.getOrElse(index) { "Hello!" },
                    timestamp = System.currentTimeMillis() - (demoNames.size - index) * 60000
                ))
            }
        }
        
        messagesFlow.value = messages
        return messagesFlow
    }
    
    fun loadMessagesForGroup(groupId: String) {
        val messages = loadMessages().filter { it.groupId == groupId }
        messagesFlow.value = messages
    }
}
