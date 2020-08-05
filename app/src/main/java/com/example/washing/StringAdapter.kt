package com.example.washing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_item_select.view.*

class StringAdapter(
    private val stringList: MutableList<String>,
    private  val status: String,
    private val onItemSelected: (position: Int) -> Unit
) :
    RecyclerView.Adapter<StringAdapter.ItemHolder>() {

    var itemCountttt = 0
    var isExpanded = false

    fun setItemCount(count: Int) {
        itemCountttt = count
    }

    init {
        if (stringList.isNotEmpty()) {
            itemCountttt = 1
        }
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            (itemView as LinearLayout).apply {
                if(status.equals("temp")){
                    if(!stringList[position].contains("Nước Lạnh")){
                        itemView.tvTitle .text= stringList[position] +"\u2103"
                    }else{
                        itemView.tvTitle.text = stringList[position]

                    }
                    if(position == 0 && !stringList[position].contains("Nước Lạnh")){
                        itemView.ivIcon.background = resources.getDrawable(R.drawable.arrow_vector)
                    }
                }else{
//                    if(!stringList[position].contains("Nước Lạnh")){
//                        itemView.tvTitle .text= stringList[position] +"\u2103"
//                    }else{
                        itemView.tvTitle.text = stringList[position]
//
//                    }
//                    if(position == 0 && !stringList[position].contains("Nước Lạnh")){
//                        itemView.ivIcon.background = resources.getDrawable(R.drawable.arrow_vector)
//                    }
                }

//                textSize = 10f
                textAlignment=View.TEXT_ALIGNMENT_CENTER
//                = 0
                setOnClickListener {
                    when (isExpanded) {
                        true -> {
                            isExpanded = false
                            itemCountttt = 1
                            selectItem(position)
                        }
                        else -> {
                            isExpanded = true
                            itemCountttt = stringList.size
                            selectItem(position)
                        }
                    }
                }
            }
        }
    }

    private fun selectItem(position: Int) {
        onItemSelected(position)
        notifyDataSetChanged()
        swapItemToFirst(position)
    }

    private fun swapItemToFirst(swapPosition: Int) {
        val swapItem = stringList[swapPosition]
        stringList.removeAt(swapPosition)
        stringList.add(0, swapItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_item_select, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return itemCountttt
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(position)
    }


}