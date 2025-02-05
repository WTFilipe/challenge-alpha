package com.filipeoliveira.hurbchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.filipeoliveira.hurbchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }


    private fun setupListeners(){
        val navController =
            supportFragmentManager.findFragmentById(R.id.activity_main_frag_container)?.findNavController()

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            val bottomNavigationView = binding.activityMainBottomNavigation.menu

            when (destination.id) {
                R.id.hotelListFragment -> {
                    bottomNavigationView.findItem(R.id.menu_item_hotel).isChecked = true
                    showBottomNavigation()
                }
                R.id.hotelFavoriteListFragment -> {
                    bottomNavigationView.findItem(R.id.menu_item_favorite).isChecked = true
                    showBottomNavigation()
                }
                else -> {
                    hideBottomNavigation()
                }
            }
        }

        binding.activityMainBottomNavigation.setOnItemSelectedListener { menuItem ->
            return@setOnItemSelectedListener when (menuItem.itemId) {
                R.id.menu_item_hotel -> {
                    navController?.navigate(R.id.to_hotelListFragment)
                    true
                }
                R.id.menu_item_favorite -> {
                    navController?.navigate(R.id.to_hotelFavoriteListFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun hideBottomNavigation() {
        binding.activityMainBottomNavigation.visibility = View.GONE
    }

    private fun showBottomNavigation() {
        binding.activityMainBottomNavigation.visibility = View.VISIBLE
    }
}