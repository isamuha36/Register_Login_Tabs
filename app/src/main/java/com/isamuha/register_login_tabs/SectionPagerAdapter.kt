package com.isamuha.register_login_tabs

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPagerAdapter (activity: AppCompatActivity) :
        FragmentStateAdapter(activity){

        override fun createFragment(position: Int): Fragment {
            var fragment: Fragment? = null
            when(position){
                0 -> fragment = RegisterFragment()
                1 -> fragment = LoginFragment()
            }
            return fragment as Fragment
        }
        override fun getItemCount(): Int {
            return 2
        }

        }