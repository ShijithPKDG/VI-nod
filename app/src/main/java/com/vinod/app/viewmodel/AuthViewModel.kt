package com.vinod.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.vinod.app.data.model.User
import com.vinod.app.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository()
    
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
    
    fun signInWithGoogle(idToken: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            repository.signInWithGoogle(idToken).fold(
                onSuccess = { user ->
                    _authState.value = AuthState.Authenticated(user)
                },
                onFailure = { error ->
                    _authState.value = AuthState.Error(error.message ?: "Sign in failed")
                }
            )
        }
    }
    
    fun createProfile(user: User) {
        viewModelScope.launch {
            repository.createUserProfile(user).fold(
                onSuccess = {
                    _authState.value = AuthState.ProfileCreated
                },
                onFailure = { error ->
                    _authState.value = AuthState.Error(error.message ?: "Profile creation failed")
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
    data class Authenticated(val user: FirebaseUser) : AuthState()
    object ProfileCreated : AuthState()
    data class Error(val message: String) : AuthState()
}
