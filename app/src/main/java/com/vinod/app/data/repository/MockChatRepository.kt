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
        val messages = loadMessages().filter { it.groupId == groupId }
        messagesFlow.value = messages
        return messagesFlow
    }
    
    fun loadMessagesForGroup(groupId: String) {
        val messages = loadMessages().filter { it.groupId == groupId }
        messagesFlow.value = messages
    }
}
