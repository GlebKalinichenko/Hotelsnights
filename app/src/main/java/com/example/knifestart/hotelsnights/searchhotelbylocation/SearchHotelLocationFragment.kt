package com.example.knifestart.hotelsnights.searchhotelbylocation

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.example.knifestart.hotelsnights.MainApplication
import com.example.knifestart.hotelsnights.R
import com.example.knifestart.hotelsnights.base.FragmentView
import com.example.knifestart.hotelsnights.di.searchhotellocation.SearchHotelLocationComponent
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 31.12.17.
 */
class SearchHotelLocationFragment : FragmentView<SearchHotelLocationComponent>() {

    @Inject
    lateinit var viewModel: SearchHotelLocationViewModel


    companion object {
        fun newInstance() : SearchHotelLocationFragment {
            var fragment = SearchHotelLocationFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun injectDependencies(component: SearchHotelLocationComponent) {
        component.inject(this)
    }

    override fun createComponent(): SearchHotelLocationComponent = (activity.application as MainApplication).searchHotelLocationComponent

    override fun setVariables() {
        binding.setVariable(BR.model, viewModel)
        binding.executePendingBindings()
    }

    override fun getLayoutId(): Int = R.layout.fragment_search_hotel_location
}