package com.example.kotlintabs

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlintabs.fragment.HomeFragment
import com.example.kotlintabs.fragment.ProfileFragment
import com.example.kotlintabs.fragment.SettingsFragment
import com.google.android.material.tabs.TabLayout



class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
     lateinit var  tabLayout:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
    }

    // method for initializing views
    private fun initializeViews(){
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.settings))
        tabLayout.addOnTabSelectedListener(this)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_home)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_user)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_gear)

        replaceFragment(HomeFragment())
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_home_white)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {

         when(tab?.position){
             0 -> {
                 tab.setIcon(R.drawable.ic_home_white)
                 tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_user)
                 tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_gear)
                 replaceFragment(HomeFragment())
             }
             1 -> {
                 tab.setIcon(R.drawable.ic_user_white)
                 tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_home)
                 tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_gear)
                 replaceFragment(ProfileFragment())
             }
             2 -> {
                 tab.setIcon(R.drawable.ic_gear_white)
                 tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_home)
                 tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_user)
                 replaceFragment(SettingsFragment())
             }
         }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }


    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }


}