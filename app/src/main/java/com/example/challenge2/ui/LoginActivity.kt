package com.example.challenge2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailInput.text.toString()
            val password = binding.edtPasswordInput.text.toString()

            if (email.isEmpty()) {
                binding.edtEmail.error = "Email cannot be empty"
                binding.edtEmailInput.requestFocus()
            } else if (password.isEmpty()) {
                binding.edtPassword.error = "Password cannot be empty"
                binding.edtPasswordInput.requestFocus()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        binding.goRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}