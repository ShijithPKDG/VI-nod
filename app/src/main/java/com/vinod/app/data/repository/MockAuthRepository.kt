package com.vinod.app.data.repository

import android.content.Context
import com.vinod.app.data.model.User

class MockAuthRepository(private val context: Context) {
    
    private val prefs = context.getSharedPreferences("mock_auth", Context.MODE_PRIVATE)
    
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }
    
    fun mockLogin(name: String): Result<User> {
        val user = User(
            uid = "demo_user_${System.currentTimeMillis()}",
            name = name,
            email = "$name@demo.com",
            photoUrl = "",
            bio = "Demo user"
        )
        
        prefs.edit()
            .putBoolean("is_logged_in", true)
            .putString("user_id", user.uid)
            .putString("user_name", user.name)
            .putString("user_email", user.email)
            .apply()
        
        return Result.success(user)
    }
    
    fun getCurrentUser(): User? {
        if (!isLoggedIn()) return null
        
        return User(
            uid = prefs.getString("user_id", "") ?: "",
            name = prefs.getString("user_name", "Demo User") ?: "Demo User",
            email = prefs.getString("user_email", "demo@demo.com") ?: "demo@demo.com",
            photoUrl = "",
            bio = "Demo user"
        )
    }
    
    fun logout() {
        prefs.edit().clear().apply()
    }
}
