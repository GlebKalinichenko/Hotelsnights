package com.example.knifestart.hotelsnights.searchhotelbyname

import android.databinding.DataBindingUtil
import android.os.Bundle
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
    var disposables: CompositeDisposable = CompositeDisposable()

    companion object {
        fun newInstance() : SearchHotelNameFragment {
            var fragment = SearchHotelNameFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_hotel_name, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disposables.add(viewModel.errorSubject.subscribe { error -> Log.d("Error", error) })
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun setState() {
        binding.setVariable(BR.model, viewModel)
        binding.executePendingBindings()
    }

    override fun injectDependencies(component: SearchHotelNameComponent) {
        component.inject(this)
    }

    override fun createComponent(): SearchHotelNameComponent = (activity!!.application as MainApplication).searchHotelNameComponent

    override fun onDestroyView() {
        disposeErrorDisposables()
        viewModel.onDestroyView()
        super.onDestroyView()
    }

    private fun disposeErrorDisposables() {
        if (!disposables.isDisposed) disposables.dispose()
    }
}