package com.vinod.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.vinod.app.R
import com.vinod.app.data.repository.MockAuthRepository
import com.vinod.app.databinding.ActivityMockLoginBinding

class MockLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMockLoginBinding
    private lateinit var authRepository: MockAuthRepository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMockLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        authRepository = MockAuthRepository(this)
        
        // Check if already logged in
        if (authRepository.isLoggedIn()) {
            navigateToMain()
            return
        }
        
        binding.btnDemoLogin.setOnClickListener {
            showNameDialog()
        }
    }
    
    private fun showNameDialog() {
        val input = TextInputEditText(this)
        input.hint = "Enter your name"
        input.setText("Demo User")
        
        AlertDialog.Builder(this)
            .setTitle("Demo Login")
            .setMessage("Enter your name for demo mode")
            .setView(input)
            .setPositiveButton("Login") { _, _ ->
                val name = input.text.toString().ifBlank { "Demo User" }
                login(name)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
    
    private fun login(name: String) {
        authRepository.mockLogin(name).fold(
            onSuccess = {
                Toast.makeText(this, "Welcome $name!", Toast.LENGTH_SHORT).show()
                navigateToMain()
            },
            onFailure = {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        )
    }
    
    private fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
