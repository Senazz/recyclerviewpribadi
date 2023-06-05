package com.example.recyclerviewpribadi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpribadi.R
import java.text.SimpleDateFormat
import java.util.*

// first create adapter class. This inherits recycler view. Recycler view now requires view holder
class TodoAdapter(val list: List<TodoModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // 3 functions of the view holder
    // 1st func
    // In this Layout inflatter is called which converts view in such a form that adapter can consume it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo, parent, false)
        )
    }


    override fun getItemCount() = list.size

    // 2nd func
    // this will set data in each card
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position]) // we are passing the object of the list that we made in the ToDoModel.kt
    }

    // 3rd func
    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    // view holder is present inside the recycler view
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtShowTime = itemView.findViewById<TextView>(R.id.txtShowCategory)
        val viewColorTag = itemView.findViewById<View>(R.id.viewColorTag)
        val txtShowTitle = itemView.findViewById<TextView>(R.id.txtShowTitle)
        val txtShowTask = itemView.findViewById<TextView>(R.id.txtShowTask)
        val txtShowCategory = itemView.findViewById<TextView>(R.id.txtShowCategory)
        val txtShowDate = itemView.findViewById<TextView>(R.id.txtShowDate)
        fun bind(todoModel: TodoModel) {
            with(itemView) {
                val colors = resources.getIntArray(R.array.random_color)
                txtShowTitle.text = todoModel.title
                txtShowTask.text = todoModel.description
                txtShowCategory.text = todoModel.category
                updateTime(todoModel.time)
                updateDate(todoModel.date)

            }
        }
        private fun updateTime(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            txtShowTime.text = sdf.format(Date(time))

        }

        private fun updateDate(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myformat)
            txtShowDate.text = sdf.format(Date(time))

        }
    }

}

