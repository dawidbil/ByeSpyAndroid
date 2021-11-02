package com.example.byespy.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.byespy.R
import com.example.byespy.adapter.ViewPagerAdapter
import com.example.byespy.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

private val drawables = arrayOf(
    R.drawable.ic_chatbubbles,
    R.drawable.ic_people,
    R.drawable.ic_settings
)

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager2
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(drawables[position])
        }.attach()
    }
}