package com.example.washing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_program.*
import kotlinx.android.synthetic.main.header.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProgramFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProgramFragment : Fragment() {
    private var param2: String? = null
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program, container, false)
    }

    companion object {
        private const val DEVICE_DATA = "device_data"

        fun newInstance(): ProgramFragment {
            val fragment = ProgramFragment()

            val args = Bundle()
//            args.putSerializable(DEVICE_DATA, deviceEntity)
            fragment.arguments = args

            return fragment
        }

        const val AUTO_BA400 = 4
        const val AUTO_PO600 = 9
        const val AUTO_PO800 = 9

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById<ViewPager2>(R.id.pager_program)
        viewPager = view.findViewById(R.id.pager_program)
        val viewPagerAdapter = ViewPagerProgramAdapter(context as FragmentActivity)
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tab_layout_program, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "THƯỜNG DÙNG"
                else -> "CHƯƠNG TRÌNH GIẶT"
            }
        }.attach()
        title_bar.text = "Chương trình giặt"

    }

}