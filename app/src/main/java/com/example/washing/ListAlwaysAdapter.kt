package com.example.washing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list_program.view.*

class ListAlwaysAdapter (private val myDataset: MutableList<String>) :
    RecyclerView.Adapter<ListAlwaysAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(position: Int) {
            (itemView as LinearLayout).apply {
                itemView.tvTitle.text = myDataset[position]
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListAlwaysAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list_always, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = myDataset.size
}