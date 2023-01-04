package com.areeb.stackviewinandroid.ui.common.diffCallBack

import androidx.recyclerview.widget.DiffUtil
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem

class DiffCallBack : DiffUtil.ItemCallback<HeroesDtoItem>() {
    override fun areItemsTheSame(oldItem: HeroesDtoItem, newItem: HeroesDtoItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: HeroesDtoItem, newItem: HeroesDtoItem): Boolean {
        return oldItem == newItem
    }
}
