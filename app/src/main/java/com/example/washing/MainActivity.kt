package com.example.washing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.pager)
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tab_layout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "CHƯƠNG TRÌNH GIẶT"
                else -> "CHƯƠNG TRÌNH SIÊU ÂM"
            }
        }.attach()
        title_bar.text = "Máy giặt"

    }
}