package com.vinod.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vinod.app.data.model.Message
import com.vinod.app.data.repository.MockChatRepository
import kotlinx.coroutines.launch

class ChatViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MockChatRepository(application)
    
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages
    
    private val _sendState = MutableLiveData<SendState>()
    val sendState: LiveData<SendState> = _sendState
    
    fun loadMessages(groupId: String) {
        viewModelScope.launch {
            repository.getMessages(groupId).collect { messageList ->
                _messages.value = messageList
            }
        }
    }
    
    fun sendMessage(message: Message) {
        viewModelScope.launch {
            repository.sendMessage(message).fold(
                onSuccess = {
                    _sendState.value = SendState.Success
                    // Reload messages to update UI
                    repository.loadMessagesForGroup(message.groupId)
                },
                onFailure = { error ->
                    _sendState.value = SendState.Error(error.message ?: "Failed to send message")
                }
            )
        }
    }
}

sealed class SendState {
    object Success : SendState()
    data class Error(val message: String) : SendState()
}
