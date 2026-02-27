package com.vinod.app.data.model

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val photoUrl: String = "",
    val bio: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
