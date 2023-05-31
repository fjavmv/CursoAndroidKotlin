package com.fjavmvazquez.viewpager2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterFragment(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val mFragmentArrayList: ArrayList<Fragment>) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return mFragmentArrayList[position]
    }

    override fun getItemCount(): Int {
        return mFragmentArrayList.size
    }
}