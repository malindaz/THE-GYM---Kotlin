package com.example.lab_exam_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_exam_3.databinding.MyGymBinding // Import the correct binding class

class GymAdapter(private val gyms: List<GymDatabase.Gym>) : RecyclerView.Adapter<GymAdapter.GymViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MyGymBinding.inflate(inflater, parent, false) // Use the correct binding class
        return GymViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GymViewHolder, position: Int) {
        val gym = gyms[position]
        holder.bind(gym)

    }

    override fun getItemCount(): Int {
        return gyms.size
    }

    inner class GymViewHolder(private val binding: MyGymBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gym: GymDatabase.Gym) {
            binding.textViewGymName.text = gym.name
            binding.textViewGymLocation.text = gym.location
            // Bind other gym details as needed
        }
    }
}
