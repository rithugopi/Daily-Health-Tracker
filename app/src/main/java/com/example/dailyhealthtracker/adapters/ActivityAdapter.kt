// adapters/ActivityAdapter.kt
package com.example.dailyhealthtracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhealthtracker.R
import com.example.dailyhealthtracker.models.Activity

class ActivityAdapter(private val items: List<Activity>) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.text_title)
        private val details: TextView = itemView.findViewById(R.id.text_details)

        fun bind(item: Activity) {
            title.text = item.name
            details.text = item.details
        }
    }
}
