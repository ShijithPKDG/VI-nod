package com.vinod.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.vinod.app.data.model.Group
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

class GroupRepository {
    private val firestore = FirebaseFirestore.getInstance()

    private fun generateInviteCode(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return (1..6).map { chars[Random.nextInt(chars.length)] }.joinToString("")
    }

    suspend fun createGroup(name: String, adminId: String): Result<Group> {
        return try {
            val groupId = firestore.collection("groups").document().id
            val inviteCode = generateInviteCode()
            val group = Group(
                groupId = groupId,
                name = name,
                inviteCode = inviteCode,
                adminId = adminId,
                members = listOf(adminId)
            )
            firestore.collection("groups")
                .document(groupId)
                .set(group)
                .await()
            Result.success(group)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun joinGroupByCode(inviteCode: String, userId: String): Result<Group> {
        return try {
            val querySnapshot = firestore.collection("groups")
                .whereEqualTo("inviteCode", inviteCode)
                .get()
                .await()
            
            if (querySnapshot.isEmpty) {
                return Result.failure(Exception("Invalid invite code"))
            }
            
            val doc = querySnapshot.documents[0]
            val group = doc.toObject(Group::class.java)!!
            
            if (group.members.contains(userId)) {
                return Result.success(group)
            }
            
            val updatedMembers = group.members + userId
            firestore.collection("groups")
                .document(group.groupId)
                .update("members", updatedMembers)
                .await()
            
            Result.success(group.copy(members = updatedMembers))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserGroups(userId: String): Result<List<Group>> {
        return try {
            val querySnapshot = firestore.collection("groups")
                .whereArrayContains("members", userId)
                .get()
                .await()
            
            val groups = querySnapshot.documents.mapNotNull { 
                it.toObject(Group::class.java) 
            }
            Result.success(groups)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
