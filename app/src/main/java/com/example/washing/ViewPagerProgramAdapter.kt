package com.example.washing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerProgramAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun getItemCount() = Companion.NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position === 0) {
            fragment =  AlwaysFragment()
        } else if (position === 1) {
            fragment = ListProgramFragment()
        }
        return fragment!!
        return fragment!!
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    companion object {
        private const val ARG_OBJECT = "object"
        private const val NUM_PAGES = 2
    }
}