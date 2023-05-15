package com.example.opsc_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.opsc_part2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val breaksFragment = BreaksFragment()
        val statsFragment = StatsFragment()
        val settingsFragment = SettingsFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.breaks -> replaceFragment(BreaksFragment())
                R.id.stats -> replaceFragment(StatsFragment())
                R.id.settings -> replaceFragment(SettingsFragment())
            }
            true

        }

    }

    private fun replaceFragment (fragment : Fragment){
        if(fragment != null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, fragment)
            fragmentTransaction.commit()
        }
    }
}