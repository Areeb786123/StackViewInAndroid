package com.areeb.stackviewinandroid.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import com.areeb.stackviewinandroid.databinding.ItemLayoutBinding
import com.areeb.stackviewinandroid.ui.common.diffCallBack.DiffCallBack
import com.areeb.stackviewinandroid.ui.home.viewHolder.HomeViewHolder

class HomeAdapter() : ListAdapter<HeroesDtoItem, HomeViewHolder>(DiffCallBack()) {
    private var currentItem = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
        onItemClick(holder)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun onItemClick(holder: HomeViewHolder) {
        if (holder.adapterPosition == currentItem) {
            holder.bindingAdapter.hiddenView.visibility = View.VISIBLE
        } else {
            holder.bindingAdapter.hiddenView.visibility = View.GONE
        }

        holder.bindingAdapter.heroImageView.setOnClickListener {
            if (currentItem != holder.adapterPosition) {
                currentItem = holder.adapterPosition
            }

            notifyDataSetChanged()
        }
    }
}
