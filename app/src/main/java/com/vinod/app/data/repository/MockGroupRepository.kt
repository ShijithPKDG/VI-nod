package com.vinod.app.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vinod.app.data.model.Group
import kotlin.random.Random

class MockGroupRepository(private val context: Context) {
    
    private val prefs = context.getSharedPreferences("mock_groups", Context.MODE_PRIVATE)
    private val gson = Gson()
    
    private fun generateInviteCode(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return (1..6).map { chars[Random.nextInt(chars.length)] }.joinToString("")
    }
    
    private fun saveGroups(groups: List<Group>) {
        val json = gson.toJson(groups)
        prefs.edit().putString("groups", json).apply()
    }
    
    private fun loadGroups(): MutableList<Group> {
        val json = prefs.getString("groups", null) ?: return mutableListOf()
        val type = object : TypeToken<MutableList<Group>>() {}.type
        return gson.fromJson(json, type) ?: mutableListOf()
    }
    
    fun createGroup(name: String, adminId: String): Result<Group> {
        val groups = loadGroups()
        val group = Group(
            groupId = "group_${System.currentTimeMillis()}",
            name = name,
            inviteCode = generateInviteCode(),
            adminId = adminId,
            members = listOf(adminId),
            createdAt = System.currentTimeMillis()
        )
        groups.add(group)
        saveGroups(groups)
        return Result.success(group)
    }
    
    fun joinGroupByCode(inviteCode: String, userId: String): Result<Group> {
        val groups = loadGroups()
        val group = groups.find { it.inviteCode == inviteCode }
            ?: return Result.failure(Exception("Invalid invite code"))
        
        if (!group.members.contains(userId)) {
            val updatedGroup = group.copy(members = group.members + userId)
            groups[groups.indexOf(group)] = updatedGroup
            saveGroups(groups)
            return Result.success(updatedGroup)
        }
        
        return Result.success(group)
    }
    
    fun getUserGroups(userId: String): Result<List<Group>> {
        val groups = loadGroups()
        val userGroups = groups.filter { it.members.contains(userId) }
        return Result.success(userGroups)
    }
    
    fun getGroup(groupId: String): Group? {
        return loadGroups().find { it.groupId == groupId }
    }
}
