package com.example.lab_exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab_exam_3.databinding.ActivitySignInBinding

class LoginActivity : AppCompatActivity() {

   private lateinit var binding: ActivitySignInBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater) // Correctly inflate using binding object

        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.LoginButton.setOnClickListener{
            val loginUsername = binding.loginUsername.text.toString()
            val loginPassword = binding.loginPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }
        binding.signupRedirect.setOnClickListener{
            val intent = Intent(this , SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun loginDatabase(username: String , password: String) {
        val userExists = databaseHelper.readUser(username, password)
        if (userExists) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, home1::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}
