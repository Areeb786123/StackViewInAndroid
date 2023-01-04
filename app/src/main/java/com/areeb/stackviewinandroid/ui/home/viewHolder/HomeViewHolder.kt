package com.areeb.stackviewinandroid.ui.home.viewHolder

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.areeb.stackviewinandroid.data.models.home.HeroesDtoItem
import com.areeb.stackviewinandroid.databinding.ItemLayoutBinding
import com.areeb.stackviewinandroid.ui.common.itemClickListener.ItemClickListener
import com.areeb.stackviewinandroid.utils.setImageView

class HomeViewHolder(private val bindingAdapter: ItemLayoutBinding) :
    RecyclerView.ViewHolder(bindingAdapter.root), View.OnClickListener {

    private lateinit var heroesDtoItem: HeroesDtoItem
    private lateinit var clickListener: ItemClickListener<HeroesDtoItem>

    fun bind(heroesDtoItem: HeroesDtoItem) {
        this.heroesDtoItem = heroesDtoItem

        bindingAdapter.NameTextView.text = heroesDtoItem.name
        bindingAdapter.firstAppearance.text = heroesDtoItem.firstappearance
        bindingAdapter.bioTextView.text = heroesDtoItem.bio
        setImageView(bindingAdapter.heroImageView, heroesDtoItem.imageurl)
    }

    override fun onClick(view: View?) {
        bindingAdapter.heroImageView.setOnClickListener {
            if (bindingAdapter.hiddenView.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(
                    bindingAdapter.baseCardview,
                    AutoTransition()
                )
            } else {
                TransitionManager.beginDelayedTransition(
                    bindingAdapter.baseCardview,
                    AutoTransition()
                )
//                }
                bindingAdapter.hiddenView.visibility = View.VISIBLE
            }
        }
    }
}
