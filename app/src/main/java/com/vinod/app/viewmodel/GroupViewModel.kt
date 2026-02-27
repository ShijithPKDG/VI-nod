package com.vinod.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vinod.app.data.model.Group
import com.vinod.app.data.repository.MockGroupRepository
import kotlinx.coroutines.launch

class GroupViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MockGroupRepository(application)
    
    private val _groupState = MutableLiveData<GroupState>()
    val groupState: LiveData<GroupState> = _groupState
    
    private val _userGroups = MutableLiveData<List<Group>>()
    val userGroups: LiveData<List<Group>> = _userGroups
    
    fun createGroup(name: String, adminId: String) {
        viewModelScope.launch {
            _groupState.value = GroupState.Loading
            repository.createGroup(name, adminId).fold(
                onSuccess = { group ->
                    _groupState.value = GroupState.GroupCreated(group)
                    loadUserGroups(adminId)
                },
                onFailure = { error ->
                    _groupState.value = GroupState.Error(error.message ?: "Failed to create group")
                }
            )
        }
    }
    
    fun joinGroup(inviteCode: String, userId: String) {
        viewModelScope.launch {
            _groupState.value = GroupState.Loading
            repository.joinGroupByCode(inviteCode, userId).fold(
                onSuccess = { group ->
                    _groupState.value = GroupState.GroupJoined(group)
                    loadUserGroups(userId)
                },
                onFailure = { error ->
                    _groupState.value = GroupState.Error(error.message ?: "Failed to join group")
                }
            )
        }
    }
    
    fun loadUserGroups(userId: String) {
        viewModelScope.launch {
            repository.getUserGroups(userId).fold(
                onSuccess = { groups ->
                    _userGroups.value = groups
                },
                onFailure = { error ->
                    _groupState.value = GroupState.Error(error.message ?: "Failed to load groups")
                }
            )
        }
    }
}

sealed class GroupState {
    object Loading : GroupState()
    data class GroupCreated(val group: Group) : GroupState()
    data class GroupJoined(val group: Group) : GroupState()
    data class Error(val message: String) : GroupState()
}
