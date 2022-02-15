package com.zaitsev.hhforstydent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zaitsev.hhforstydent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    lateinit var toolbar: MaterialToolbar
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentNavigate) as NavHostFragment
        navController = navHostFragment.navController
        toolbar = binding.mainToolbar
        bottomNavigationView = binding.mainBottomNav

        setupBottomNavigationView()
        setupToolbar()

    }

    private fun setupBottomNavigationView(){
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}