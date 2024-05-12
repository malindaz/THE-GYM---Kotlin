package com.example.lab_exam_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class get_started : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
    }

    fun onLayout(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}