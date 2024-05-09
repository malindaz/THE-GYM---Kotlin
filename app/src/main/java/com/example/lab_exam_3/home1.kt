package com.example.lab_exam_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import kotlinx.coroutines.newFixedThreadPoolContext

class home1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)
    }

    fun onClickhome(view: View) {
        val intent = Intent(this, menu::class.java)
        startActivity(intent)
    }

    fun onFindgym(view: View) {
        val intent = Intent(this, find_a_gym::class.java)
        startActivity(intent)
    }
    fun onClickMyProfile(view: View) {
        val intent = Intent(this, my_profile::class.java)
        startActivity(intent)
    }

    fun onAddGym(view: View) {
        val intent = Intent(this, add_gym::class.java)
        startActivity(intent)
        }
}