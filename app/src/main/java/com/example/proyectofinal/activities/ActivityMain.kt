package com.example.proyectofinal.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.jetbrains.anko.find
import androidx.fragment.app.Fragment

class ActivityMain : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val homeFragment: Fragment = FragmentHome()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        val navigation = find<BottomNavigationView>(R.id.activity_main_bnv_navigation)
        navigation.selectedItemId = R.id.action_home
        navigation.setOnNavigationItemSelectedListener(this)

        changeFragment(homeFragment)
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_main_fl_main_content, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val newFragmentReference = when (item.itemId) {
            R.id.action_home -> {
                homeFragment
            }
            R.id.action_profile -> {
                //Cambiar
                homeFragment
            }
            R.id.action_search -> {
                //Cambiar
                homeFragment
            }
            else -> homeFragment
        }
        changeFragment(newFragmentReference)
        return true
    }

}