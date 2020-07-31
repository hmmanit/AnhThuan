package com.homanad.android.recytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val stringAdapter = StringAdapter(dummyList) {
            //on selected
        }

        val myLayoutManager = LinearLayoutManager(this@MainActivity)
        myLayoutManager.reverseLayout = true
//        myLayoutManager.stackFromEnd = true

        rv_main.apply {
            adapter = stringAdapter
            layoutManager = myLayoutManager
        }

    }
}
