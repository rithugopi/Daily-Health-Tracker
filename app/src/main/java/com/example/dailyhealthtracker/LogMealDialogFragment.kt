package com.example.dailyhealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dailyhealthtracker.models.Activity

class LogMealDialogFragment : DialogFragment() {

    interface LogMealListener {
        fun onMealLogged(meal: Activity)
    }

    private var logMealListener: LogMealListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_meal_dialog, container, false)

        // Setup Spinner
        val mealTypes = arrayOf("Breakfast", "Lunch", "Dinner", "Snacks")
        val spinner: Spinner = view.findViewById(R.id.spinner_meal_type)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mealTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Log Meal Button
        view.findViewById<Button>(R.id.button_log_meal).setOnClickListener {
            val mealName = view.findViewById<EditText>(R.id.edit_text_meal_name).text.toString()
            val mealType = spinner.selectedItem.toString()
            if (mealName.isNotEmpty()) {
                val newMeal = Activity(
                    id = 0,
                    type = "meal",
                    name = "$mealType: $mealName",
                    details = "Logged Meal",
                    timestamp = System.currentTimeMillis()
                )
                logMealListener?.onMealLogged(newMeal)
                dismiss()
            } else {
                Toast.makeText(context, "Please enter meal name", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    fun setLogMealListener(listener: LogMealListener) {
        logMealListener = listener
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}
