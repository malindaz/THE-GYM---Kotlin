//package com.example.lab_exam_3
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.content.Intent
//import android.view.View
//import android.widget.Button
//import kotlinx.coroutines.newFixedThreadPoolContext
//
//class add_gym : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_gym2)
//    }
//
//    fun onAddGym(view: View) {
//        val intent = Intent(this, my_gym::class.java)
//        startActivity(intent)
//    }
//}

// AddGym.kt

package com.example.lab_exam_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.lab_exam_3.databinding.ActivityAddGym2Binding

class add_gym : AppCompatActivity() {

    private lateinit var binding: ActivityAddGym2Binding
    private lateinit var databaseHelper: GymDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGym2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = GymDatabase(this)

        binding.button3.setOnClickListener {
            val gymName = binding.gymName.text.toString()
            val gymLocation = binding.gymLocation.text.toString()
            val gymFee = binding.gymFee.text.toString().toDoubleOrNull()
            val gymOpeningHours = binding.gymOpeningHours.text.toString()

            if (gymName.isNotEmpty() && gymLocation.isNotEmpty() && gymFee != null && gymOpeningHours.isNotEmpty()) {
                addGymToDatabase(gymName, gymLocation, gymFee, gymOpeningHours)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addGymToDatabase(name: String, location: String, fee: Double, openingHours: String) {
        val insertedRowID = databaseHelper.insertGym(name, location, fee, openingHours)
        if (insertedRowID != -1L) {
            Toast.makeText(this, "Gym added successfully", Toast.LENGTH_SHORT).show()
            // Handle success, if needed
            val intent = Intent(this, my_gym::class.java)
            startActivity(intent)
          //  finish()
        } else {
            Toast.makeText(this, "Failed to add gym", Toast.LENGTH_SHORT).show()
            // Handle failure, if needed
        }
    }
}
