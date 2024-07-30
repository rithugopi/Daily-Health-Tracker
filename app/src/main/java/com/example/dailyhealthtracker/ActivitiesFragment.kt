// ActivitiesFragment.kt
package com.example.dailyhealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhealthtracker.adapters.ActivityAdapter
import com.example.dailyhealthtracker.models.Activity

class ActivitiesFragment : Fragment(), LogMealDialogFragment.LogMealListener {

    private lateinit var activitiesAdapter: ActivityAdapter
    private val activitiesList = mutableListOf<Activity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activities, container, false)

        // Initialize RecyclerView
        activitiesAdapter = ActivityAdapter(activitiesList)
        view.findViewById<RecyclerView>(R.id.recycler_view_activities).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = activitiesAdapter
        }

        // Populate the list with initial data (if any)
        loadData()

        return view
    }

    private fun loadData() {
        // Load data from database or other sources
        // For now, let's add some dummy data
//        activitiesList.add(Activity(1, "activity", "Morning Run", "Details about the run", System.currentTimeMillis()))
//        activitiesList.add(Activity(2, "meal", "Breakfast", "Details about the meal", System.currentTimeMillis()))
        activitiesAdapter.notifyDataSetChanged()
    }

    override fun onMealLogged(meal: Activity) {
        activitiesList.add(meal)
        activitiesAdapter.notifyDataSetChanged()
    }
}
