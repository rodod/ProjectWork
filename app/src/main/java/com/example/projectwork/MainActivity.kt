package com.example.projectwork

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import com.example.projectwork.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navigateToHome()
                    true
                }
                R.id.map -> {
                    navigateToMap()
                    true
                }
                R.id.account -> {
                    navigateToAccount()
                    true
                }

                else -> {
                    navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
                    true
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    private fun navigateToHome() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.home_fragment)
    }

    private fun navigateToAccount() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.account_fragment)
    }

    private fun navigateToMap() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.fragmentMap)
    }
}