package com.example.lab_exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class my_profile: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_gym)

        fun onEdit(view: View) {
            val intent = Intent(this, edit_profile::class.java)
            startActivity(intent)
        }
        fun onLogout(view: View) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        fun ClickHome(view: View) {
            val intent = Intent(this, home1::class.java)
            startActivity(intent)
        }
        fun onClickMyProfile(view: View) {
            val intent = Intent(this, my_profile::class.java)
            startActivity(intent)
        }


    }
}