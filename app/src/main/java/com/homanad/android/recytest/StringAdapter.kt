package com.homanad.android.recytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StringAdapter(
    private val stringList: List<String>,
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
            (itemView as TextView).apply {
                text = stringList[position]
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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return itemCountttt
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(position)
    }


}