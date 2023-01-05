package com.areeb.stackviewinandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import com.areeb.stackviewinandroid.databinding.ItemLayoutBinding
import com.areeb.stackviewinandroid.ui.common.diffCallBack.DiffCallBack
import com.areeb.stackviewinandroid.ui.home.viewHolder.HomeViewHolder

class HomeAdapter() : ListAdapter<HeroesDtoItem, HomeViewHolder>(DiffCallBack()) {
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
    }
}
