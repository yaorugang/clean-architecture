package com.yaorugang.afterpay.ui

import android.os.Bundle
import android.view.Menu
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.yaorugang.afterpay.R
import com.yaorugang.afterpay.databinding.ActivityMainBinding
import com.yaorugang.afterpay.ui.carlist.CarListFragmentDirections
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.toolbar.apply {
            setupWithNavController(navController, appBarConfiguration)
            inflateMenu(R.menu.information)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.information -> {
                        navController.navigate(CarListFragmentDirections.actionToInformationFragment())
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.information, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun showSettingsMenu(visible: Boolean) {
        binding.toolbar.menu[0].isVisible = visible
    }
}