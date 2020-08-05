package com.example.washing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    //    override fun getItem(position: Int): Fragment {
//        var fragment: Fragment? = null
//        when {
//            position === 0 -> {
//                fragment = WashingProgramFragment()
//            }
//            position === 1 -> {
//                fragment = UltraSonicProgramFragment()
//            }
//        }
//        return fragment!!
//    }


//    override fun getPageTitle(position: Int): CharSequence? {
//        var title: String? = null
//        when {
//            position === 0 -> {
//                title = "Washing Program"
//            }
//            position === 1 -> {
//                title = "Ultra Sonic Program"
//            }
//        }
//        return title
//    }

    override fun getItemCount() = Companion.NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position === 0) {
            fragment = WashingProgramFragment()
        } else if (position === 1) {
            fragment = UltraSonicProgramFragment()
        }
        return fragment!!
        // Return a NEW fragment instance in createFragment(int)
//        val fragment = UltraSonicProgramFragment()
//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, position + 1)
//        }
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