package com.areeb.stackviewinandroid.ui.common.itemClickListener

class ItemClickListener<T> (val clickListener: (t: T) -> Unit) {
    fun onClick(t: T) = clickListener(t)
}
