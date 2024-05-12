package com.example.lab_exam_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.lab_exam_3.databinding.ActivityMyGymBinding

class my_gym : AppCompatActivity() {

    private lateinit var binding: ActivityMyGymBinding
    private lateinit var gymDatabase: GymDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyGymBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gymDatabase = GymDatabase(this)

        displayGymDetails()
    }

    private fun displayGymDetails() {
        val gyms = gymDatabase.getAllGyms()
        val adapter = GymAdapter(gyms)
        binding.recyclerViewGyms.adapter = adapter
    }


    fun onEditClick(view: View) {
        val intent = Intent(this, add_gym::class.java)
        startActivity(intent)
    }
//
//    fun onDeleteClick(view: View) {
//        val intent = Intent(this, home1::class.java)
//        startActivity(intent)
//    }

    fun onClickhome(view: View) {
        val intent = Intent(this, menu::class.java)
        startActivity(intent)
    }

    fun onClickMyProfile(view: View) {
        val intent = Intent(this, my_profile::class.java)
        startActivity(intent)
    }
}

// MyGym.kt

//package com.example.lab_exam_3
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.lab_exam_3.databinding.ActivityMyGymBinding
//
//class MyGym : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMyGymBinding
//    private lateinit var gymDatabase: GymDatabase
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMyGymBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        gymDatabase = GymDatabase(this)
//
//        setupRecyclerView()
//    }
//
//    private fun setupRecyclerView() {
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewGyms)
//        val gyms = gymDatabase.getAllGyms()
//        val adapter = GymAdapter(gyms)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//    }
//
//    fun onEditClick(view: View) {
//        val intent = Intent(this, AddGym::class.java)
//        startActivity(intent)
//    }
//
//    fun onDeleteClick(view: View) {
//        val intent = Intent(this, Home1::class.java)
//        startActivity(intent)
//    }
//}
