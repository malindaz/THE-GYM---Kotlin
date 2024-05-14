package com.example.lab_exam_3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GymAdapter(private var gyms: List<GymDatabase.Gym>, private val context: Context) :
    RecyclerView.Adapter<GymAdapter.GymViewHolder>() {

    class GymViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonEdit: Any
            get() {
                TODO()
            }
        val titleTextView: TextView = itemView.findViewById(R.id.textView5)
        val button: Button = itemView.findViewById(R.id.buttonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_my_gym, parent, false)
        return GymViewHolder(view)
    }


    override fun getItemCount(): Int {
        return gyms.size
    }

    override fun onBindViewHolder(holder: GymViewHolder, position: Int) {
        val gym = gyms[position]
        holder.titleTextView.text = gym.name

//        holder.buttonEdit.onAdd{
//            val intent = Intent(holder.itemView.context, edit::class.java).apply {
//                putExtra("gym_id", gym.id)
//
//            }

//            holder.itemView.context.startActivity(intent)
//        }
//        holder.button.setOnClickListener {
//            val gymDatabase = GymDatabase(holder.itemView.context)
//            gymDatabase.deleteGym(gym.id.toInt()) // Convert id to Int
//            refreshData(gymDatabase.getAllGyms())
//            Toast.makeText(holder.itemView.context, "Gym is Deleted", Toast.LENGTH_SHORT).show()
//        }
//    }

//    private fun putExtra(s: String, id: Any) {
//        TODO("Not yet implemented")
//    }


        fun refreshData(newGyms: List<GymDatabase.Gym>) {
            gyms = newGyms
            notifyDataSetChanged()
        }
    }

    private fun Any.toInt(): Int {
        return try {
            this.toString().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Cannot convert $this to Int.")
        }
    }

    fun refreshData(allGyms: List<GymDatabase.Gym>) {

    }
}
