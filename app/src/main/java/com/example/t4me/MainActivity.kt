package com.example.t4me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.t4me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up initial fragment
        replaceFragment(HomeFragment())

        // Select the middle icon initially
        binding.bottomNavigationView.selectedItemId = R.id.home

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.chat -> replaceFragment(ChatFragment())
                R.id.report -> replaceFragment(ReportFragment())
                R.id.schedule -> replaceFragment(ScheduleFragment())
                R.id.setting -> replaceFragment(SettingFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
