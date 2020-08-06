package com.example.washing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.washing.helper.OnSnapPositionChangeListener
import com.example.washing.helper.SnapOnScrollListener
import com.example.washing.helper.getSnapPosition
import kotlinx.android.synthetic.main.fragment_ultra_sonic_program.*

class UltraSonicProgramFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ultra_sonic_program, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(Companion.ARG_OBJECT) }?.apply {
//            textName.text = getInt(Companion.ARG_OBJECT).toString()
        }
        val stringTempAdapter = ImageAdapter(titelFuntion) {
            //on selected
        }
        val stringTitleAdapter = TitleFuntionAdapter(titelFuntion) {
            //on selected
        }
        val myLayoutManager =
            CenterZoomLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val myLayoutManager1 =
            CenterZoomLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        myLayoutManager.reverseLayout = false

        val pagerSnapHelper = PagerSnapHelper()

        val imageOnScrollListener = SnapOnScrollListener(
            pagerSnapHelper,
            onImageSnapPositionChangeListener
        )
        rv_image.apply {
            adapter = stringTempAdapter
            layoutManager = myLayoutManager
            pagerSnapHelper.attachToRecyclerView(this)
            addOnScrollListener(imageOnScrollListener)
        }

        val titleOnScrollListener = SnapOnScrollListener(
            pagerSnapHelper,
            onTitleSnapPositionChangeListener
        )
        rvTitle.apply {
            adapter = stringTitleAdapter
            layoutManager = myLayoutManager1
            pagerSnapHelper.attachToRecyclerView(this)
            addOnScrollListener(titleOnScrollListener)
        }

        button_left.setOnClickListener {
            val currentPosition = pagerSnapHelper.getSnapPosition(rvTitle)
            if (currentPosition > 0)
                rvTitle.smoothScrollToPosition(currentPosition - 1)
        }

        button_right.setOnClickListener {
            val currentPosition = pagerSnapHelper.getSnapPosition(rvTitle)
            if (currentPosition < stringTitleAdapter.itemCount - 1)
                rvTitle.smoothScrollToPosition(currentPosition + 1)
        }
    }

    private val onImageSnapPositionChangeListener = object : OnSnapPositionChangeListener {
        override fun onSnapPositionChanged(position: Int) {
            rvTitle.smoothScrollToPosition(position)
        }
    }

    private val onTitleSnapPositionChangeListener = object : OnSnapPositionChangeListener {
        override fun onSnapPositionChanged(position: Int) {
            rv_image.smoothScrollToPosition(position)
        }
    }

    companion object {
        private const val ARG_OBJECT = "object"
    }

}