package com.aamirashraf.myclicks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.aamirashraf.myclicks.databinding.RvItemsBinding

class MyAdapter(val onItemClick:(Item)->Unit) : ListAdapter<Item, MyAdapter.MyViewHolder>(Companion) {
    inner class MyViewHolder(val binding: RvItemsBinding):ViewHolder(binding.root)
    companion object:DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name==newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RvItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curr=currentList[position]
        holder.binding.apply {
            tvRv.text=curr.name
            tvRv.setOnClickListener {
//                onItemClick(curr)
                callback?.invoke(curr)
            }
        }
    }
    private var callback:((Item)->Unit)?=null
    fun setCallback(callbackk:(Item)->Unit){
        callback=callbackk
    }
}