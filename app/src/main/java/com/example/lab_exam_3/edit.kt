package com.example.lab_exam_3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
//import com.example.lab_exam_3.databinding.ActivityMyGymBinding
import com.example.lab_exam_3.GymDatabase


class edit : AppCompatActivity() {
//
//    private lateinit var binding : ActivityMyGymBinding
//    private lateinit var database: GymDatabase
//    private var gymId: Int = -1
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMyGymBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        database = GymDatabase(this)
//
//        gymId = intent.getIntExtra("gym_id", -1)
//        if(gymId == -1){
//            finish()
//            return
//        }

//        val notification = database.findViewById(gymId)
//        binding.updatetitleEditText.setText(gymId.name)
//        binding.updatecontentEditText.setText(notification.content)
//
//        binding.button3.setOnClickListener{
//            val newTitle = binding.updatetitleEditText.text.toString()
//            val newContent = binding.updatecontentEditText.text.toString()
//            val updateGym = Gym(gymId,newContent,newContent)
//            database.onUpgrade(updateGym)
//            finish()
//            Toast.makeText(this,"Changes Saved successfully",Toast.LENGTH_SHORT).show()
//        }

    }
//}

class ActivityMyGymBinding {
    companion object {
        fun inflate(layoutInflater: LayoutInflater): ActivityMyGymBinding {
            TODO("Not yet implemented")
        }
    }

}
