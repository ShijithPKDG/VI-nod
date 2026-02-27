package com.vinod.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vinod.app.data.model.User
import com.vinod.app.data.repository.MockAuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MockAuthRepository(application)
    
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState
    
    init {
        checkCurrentUser()
    }
    
    private fun checkCurrentUser() {
        val user = repository.getCurrentUser()
        if (user != null) {
            _authState.value = AuthState.Authenticated(user)
        } else {
            _authState.value = AuthState.Unauthenticated
        }
    }
    
    fun signIn(name: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            repository.signIn(name).fold(
                onSuccess = { user ->
                    _authState.value = AuthState.Authenticated(user)
                },
                onFailure = { error ->
                    _authState.value = AuthState.Error(error.message ?: "Sign in failed")
                }
            )
        }
    }
    
    fun signOut() {
        repository.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}

sealed class AuthState {
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Authenticated(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
}
