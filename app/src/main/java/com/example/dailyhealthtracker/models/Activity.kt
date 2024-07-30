// models/Activity.kt
package com.example.dailyhealthtracker.models

data class Activity(
    val id: Int,
    val type: String, // "activity" or "meal"
    val name: String,
    val details: String,
    val timestamp: Long
)
