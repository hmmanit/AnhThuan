package com.example.washing

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.annotation.RequiresApi


class PopUpClass {
    @RequiresApi(Build.VERSION_CODES.M)
    fun showPopupWindow(view: View) {

        //Create a View object yourself through inflater
        val inflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val popupView: View = inflater.inflate(R.layout.custom_popup_window, null)
        val popupView: View = inflater.inflate(R.layout.custom_poup_window,null)

        //Specify the length and width through constants
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT

        //Make Inactive Items Outside Of PopupWindow
        val focusable = true

        //Create a window with our parameters
        val popupWindow = PopupWindow(popupView, width, height, focusable)

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.LEFT, 0, 0)
        popupWindow.overlapAnchor = false



        //Handler for clicking on the inactive zone of the window
        popupView.setOnTouchListener { v, event -> //Close the window when clicked
            popupWindow.dismiss()
            true
        }
    }
}