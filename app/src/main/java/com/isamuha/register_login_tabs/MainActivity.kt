package com.isamuha.register_login_tabs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.isamuha.register_login_tabs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.register,
            R.string.login
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur adapter untuk ViewPager2
        val sectionPagerAdapter = SectionPagerAdapter(this)
        binding.viewPager.adapter = sectionPagerAdapter

        // Mengatur TabLayout dengan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position -> tab.text = resources.getString(
            TAB_TITLES[position])}.attach()

        // Mengatur elevasi ActionBar
        supportActionBar?.elevation = 0f

        // Set Toolbar
//        setSupportActionBar(binding.toolbar)
//
        // Mengubah font title pada Toolbar
//        binding.toolbar.title = getString(R.string.app_name)
//        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))

        // Membuat custom Typeface
        binding.toolbar.setTitleTextAppearance(this, R.style.CustomToolbar)
    }
}