package com.example.homework2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    val data = listOf<Fragment>(
        BurgerFragment(),
        BeverageFragment(),
        SideFragment()
    )
    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return data[position]
    }
}