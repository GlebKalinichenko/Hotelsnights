package com.example.knifestart.hotelsnights.searchhotelbyname

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.example.knifestart.hotelsnights.MainApplication
import com.example.knifestart.hotelsnights.R
import com.example.knifestart.hotelsnights.base.FragmentView
import com.example.knifestart.hotelsnights.di.searchhotelname.SearchHotelNameComponent
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 31.12.17.
 */
class SearchHotelNameFragment : FragmentView<SearchHotelNameComponent>() {

    @Inject
    lateinit var viewModel: SearchHotelNameViewModel

    companion object {
        fun newInstance() : SearchHotelNameFragment {
            var fragment = SearchHotelNameFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorDisposable.add(viewModel.errorSubject.subscribe { error -> Log.d("Error", error) })
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun setVariables() {
        binding.setVariable(BR.model, viewModel)
        binding.executePendingBindings()
    }

    override fun getLayoutId(): Int = R.layout.fragment_search_hotel_name

    override fun injectDependencies(component: SearchHotelNameComponent) {
        component.inject(this)
    }

    override fun createComponent(): SearchHotelNameComponent = (activity!!.application as MainApplication).searchHotelNameComponent

    override fun onDestroyView() {
        viewModel.onDestroyView()
        super.onDestroyView()
    }
}