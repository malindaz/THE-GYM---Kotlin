package com.example.lab_exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun onMyProfile(view: View) {
        val intent = Intent(this, my_profile::class.java)
        startActivity(intent)
    }
    fun onMyGym(view: View) {
        val intent = Intent(this, my_gym::class.java)
        startActivity(intent)
    }
    fun onLogout(view: View) {
        val intent = Intent(this, sign_in::class.java)
        startActivity(intent)
    }
}




