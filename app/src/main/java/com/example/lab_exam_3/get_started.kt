package com.example.lab_exam_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import kotlinx.coroutines.newFixedThreadPoolContext

class get_started : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
    }

    fun onGetStarted(view: View) {
        val intent = Intent(this, sign_in::class.java)
        startActivity(intent)
    }
}