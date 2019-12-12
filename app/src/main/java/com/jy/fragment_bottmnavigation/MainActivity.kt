package com.jy.fragment_bottmnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val TAG = this::class.java

    private val navFragments by lazy { findNavController(R.id.host_fragment) }
    private val bottomNav by lazy { findViewById<BottomNavigationView>(R.id.bottom_nav) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_friend, R.id.navigation_statics, R.id.navigation_setting))
        setupActionBarWithNavController(navFragments, appBarConfiguration)
        bottomNav.setupWithNavController(navFragments)

//        bottomNav.getOrCreateBadge(R.id.navigation_home).number = 5
        val menuItemId = bottomNav.menu.getItem(0).itemId
        val badgeDrawable = bottomNav.getOrCreateBadge(menuItemId)
        badgeDrawable.isVisible = true
        badgeDrawable.number = 1
    }

}
