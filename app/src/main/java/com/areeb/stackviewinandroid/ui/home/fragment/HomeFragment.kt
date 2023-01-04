package com.areeb.stackviewinandroid.ui.home.fragment

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.areeb.stackviewinandroid.databinding.FragmentHomeBinding
import com.areeb.stackviewinandroid.ui.base.fragment.BaseFragment
import com.areeb.stackviewinandroid.ui.common.itemClickListener.ItemClickListener
import com.areeb.stackviewinandroid.ui.home.adapter.HomeAdapter
import com.areeb.stackviewinandroid.ui.home.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _fragmentBinding: FragmentHomeBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!
    private var adapter: HomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return _fragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observer()
    }

    private fun observer() {
        viewModel.heroes.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }
    }

    private fun init() {
        adapter = HomeAdapter()
        fragmentBinding.homeRecyclerView.adapter = adapter
    }

//    private fun test() {
//        fragmentBinding.arrowButton.setOnClickListener {
//            // If the CardView is already expanded, set its visibility
//            // to gone and change the expand less icon to expand more.
//            if (fragmentBinding.hiddenView.visibility == View.VISIBLE) {
//                // The transition of the hiddenView is carried out by the TransitionManager class.
//                // Here we use an object of the AutoTransition Class to create a default transition
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                TransitionManager.beginDelayedTransition(
//                    fragmentBinding.baseCardview,
//                    AutoTransition()
//                )
////                }
//                fragmentBinding.hiddenView.visibility = View.GONE
////                fragmentBinding.arrowButton.setImageResource(R.drawable.ic_baseline_expand_more_24)
//            } else {
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                TransitionManager.beginDelayedTransition(
//                    fragmentBinding.baseCardview,
//                    AutoTransition()
//                )
////                }
//                fragmentBinding.hiddenView.visibility = View.VISIBLE
////                arrow.setImageResource(R.drawable.ic_baseline_expand_less_24)
//            }
//        }
//    }
}
