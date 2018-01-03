package com.example.knifestart.hotelsnights.searchhotelbyname

import android.databinding.Bindable
import android.util.Log
import com.android.databinding.library.baseAdapters.BR
import com.example.knifestart.domain.searchhotelname.SearchHotelNameUseCase
import com.example.knifestart.hotelsnights.R
import com.example.knifestart.hotelsnights.adapter.HotelAdapter
import com.example.knifestart.hotelsnights.base.FragmentViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 01.01.18.
 */
class SearchHotelNameViewModel @Inject constructor(var router: Router, var fetchHotelUseCase: SearchHotelNameUseCase,
    private var isProgressVisible: Boolean = false, private val VISIBLE_THRESHOLD: Int = 5) : FragmentViewModel(), ISearchHotelNameViewModel {

    var adapter = HotelAdapter(R.layout.item_hotel) {
        post -> Log.d(LOG_TAG, post.fullName)
    }
    override fun onCreateView() {

    }

    override fun onStart() {
        searchHotels("palace", VISIBLE_THRESHOLD, false)
    }

    override fun searchHotels(query: String, limit: Int, isRefresh: Boolean) {
        setProgressVisible(true)
        fetchHotelUseCase.run(SearchHotelNameUseCase.FetchHotelNameParam(query, limit))
                .doOnError { i -> Log.d(LOG_TAG,  "Error")  }
                .subscribe {
                    hotels -> if (!isRefresh) adapter.addDataSource(hotels) else adapter.cleanAndAddDataSource(hotels)
                    setProgressVisible(false)
                }
    }

    override fun refreshHotels() {
        searchHotels("palace", VISIBLE_THRESHOLD, true)
    }

    @Bindable
    fun isProgressVisible() = isProgressVisible

    fun setProgressVisible(isProgressVisible: Boolean){
        this.isProgressVisible = isProgressVisible
        notifyPropertyChanged(BR.progressVisible)
    }
}