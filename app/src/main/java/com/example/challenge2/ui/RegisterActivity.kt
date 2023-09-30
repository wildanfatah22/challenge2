package com.example.challenge2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge2.R
import com.example.challenge2.databinding.ActivityLoginBinding
import com.example.challenge2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.edtNameInput.text.toString()
            val email = binding.edtEmailInput.text.toString()
            val password = binding.edtPasswordInput.text.toString()

            if (name.isEmpty()) {
                binding.edtName.error = "Name cannot be empty"
                binding.edtNameInput.requestFocus()
            } else if (email.isEmpty()) {
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

        binding.goLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}