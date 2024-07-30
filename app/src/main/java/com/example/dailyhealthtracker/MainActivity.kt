// MainActivity.kt
package com.example.dailyhealthtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var activitiesFragment: ActivitiesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activitiesFragment = ActivitiesFragment()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_water_intake -> {
                    loadFragment(WaterIntakeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_activities -> {
                    loadFragment(activitiesFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_log_meal -> {
                    openLogMealDialog()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        // Load default fragment
        if (savedInstanceState == null) {
            loadFragment(WaterIntakeFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }

    private fun openLogMealDialog() {
        val logMealDialog = LogMealDialogFragment()
        logMealDialog.setLogMealListener(activitiesFragment)
        logMealDialog.show(supportFragmentManager, "LogMealDialogFragment")
    }
}
