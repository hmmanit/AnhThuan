package com.example.washing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val stringList: MutableList<String>,
    private val onItemSelected: (position: Int) -> Unit
) :
    RecyclerView.Adapter<ImageAdapter.ItemHolder>() {

    var itemCountttt = 0
    var isExpanded = false

    fun setItemCount(count: Int) {
        itemCountttt = count
    }

    fun getItemTitle(position: Int): String {
        return stringList[position]
    }

    init {
        if (stringList.isNotEmpty()) {
            itemCountttt = 1
        }
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            (itemView as LinearLayout).apply {

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
            .inflate(R.layout.custom_item_image, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount() = stringList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(position)
    }


}