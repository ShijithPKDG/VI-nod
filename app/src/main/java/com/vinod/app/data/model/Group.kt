package com.vinod.app.data.model

data class Group(
    val groupId: String = "",
    val name: String = "",
    val inviteCode: String = "",
    val adminId: String = "",
    val members: List<String> = emptyList(),
    val createdAt: Long = System.currentTimeMillis()
)
