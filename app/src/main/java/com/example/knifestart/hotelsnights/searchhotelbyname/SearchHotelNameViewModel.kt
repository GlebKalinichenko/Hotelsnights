package com.example.knifestart.hotelsnights.searchhotelbyname

import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.example.knifestart.domain.searchhotelname.SearchHotelNameUseCase
import com.example.knifestart.hotelsnights.base.FragmentViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 01.01.18.
 */
class SearchHotelNameViewModel @Inject constructor(var router: Router, var fetchHotelUseCase: SearchHotelNameUseCase,
    private var isProgressVisible: Boolean = false) : FragmentViewModel(), ISearchHotelNameViewModel {

    override fun onCreateView() {

    }

    override fun onStart() {

    }

    override fun searchHotels() {

    }

    @Bindable
    fun isProgressVisible() = isProgressVisible

    fun setProgressVisible(isProgressVisible: Boolean){
        this.isProgressVisible = isProgressVisible
        notifyPropertyChanged(BR.progressVisible)
    }
}