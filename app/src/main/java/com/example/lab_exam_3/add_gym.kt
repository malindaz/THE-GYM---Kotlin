package com.example.lab_exam_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import kotlinx.coroutines.newFixedThreadPoolContext

class add_gym : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_gym2)
    }

    fun onAddGym(view: View) {
        val intent = Intent(this, my_gym::class.java)
        startActivity(intent)
    }
}