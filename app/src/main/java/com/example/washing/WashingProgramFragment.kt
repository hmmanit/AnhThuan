package com.example.washing

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_washing_program.*


class WashingProgramFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val mDropdown: PopupWindow? = null
    var mInflater: LayoutInflater? = null
    var pop: Button? = null
    private lateinit var  fm: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_washing_program, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stringTempAdapter = StringAdapter(tempList,"temp") {
            //on selected
        }
        val stringPowerAdapter = StringAdapter(powerList,"power") {
            //on selected
        }
        val stringWaterAdapter = StringAdapter(waterList,"water") {
            //on selected
        }
        val stringSoftenerAdapter = StringAdapter(softenerList,"soft") {
            //on selected
        }

        val myLayoutManager = LinearLayoutManager(context)
        myLayoutManager.reverseLayout = true
        val myLayoutManager2 = LinearLayoutManager(context)
        myLayoutManager.reverseLayout = true
        val myLayoutManager3 = LinearLayoutManager(context)
        myLayoutManager.reverseLayout = true
        val myLayoutManager4 = LinearLayoutManager(context)
        myLayoutManager.reverseLayout = true
//        myLayoutManager.stackFromEnd = true

        rv_temp.apply {
            adapter = stringTempAdapter
            layoutManager = myLayoutManager
        }
        rv_temp1.apply {
            adapter = stringPowerAdapter
            layoutManager = myLayoutManager2
        }
        rv_temp3.apply {
            adapter = stringWaterAdapter
            layoutManager = myLayoutManager3
        }
        val apply = rv_temp4.apply {
            adapter = stringSoftenerAdapter
            layoutManager = myLayoutManager4
        }

        buttonWashingProgram.setOnClickListener {
            FragmentUtils.addFragment(fragmentManager, ProgramFragment.newInstance(), R.id.content, true)
            return@setOnClickListener
        }

    }

//    companion object {
//
//    }
}