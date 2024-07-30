package com.example.dailyhealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class WaterIntakeFragment : Fragment() {
    private var totalWaterConsumed = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_water_intake, container, false)

        val waterAmountEditText = view.findViewById<EditText>(R.id.water_amount_edit_text)
        val logWaterButton = view.findViewById<Button>(R.id.log_water_button)
        val totalWaterTextView = view.findViewById<TextView>(R.id.total_water_text_view)

        logWaterButton.setOnClickListener {
            val waterAmount = waterAmountEditText.text.toString().toIntOrNull() ?: 0
            totalWaterConsumed += waterAmount
            totalWaterTextView.text = "Total Water Consumed: $totalWaterConsumed ml"
        }

        return view
    }
}
