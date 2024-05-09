package com.example.lab_exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class my_gym : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_gym)

        fun onEditClick(view: View) {
            val intent = Intent(this, add_gym::class.java)
            startActivity(intent)
        }
        fun onDeleteClick(view: View) {
            val intent = Intent(this, home1::class.java)
            startActivity(intent)
        }
        fun onClickhome(view: View) {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }
        fun onClickMyProfile(view: View) {
            val intent = Intent(this, my_profile::class.java)
            startActivity(intent)
        }


    }
}