package com.example.lab_exam_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import kotlinx.coroutines.newFixedThreadPoolContext

class sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }
    fun onLogin(view: View) {
        val intent = Intent(this, home1::class.java)
        startActivity(intent)
    }
    fun onSignUp(view: View) {
        val intent = Intent(this, sign_up::class.java)
        startActivity(intent)
    }
}