package com.example.knifestart.hotelsnights.di.searchhotelname

import com.example.knifestart.hotelsnights.di.scope.HotelScope
import com.example.knifestart.hotelsnights.searchhotelbyname.SearchHotelNameViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class SearchHotelNameModule {

    @Provides
    @HotelScope
    fun provideViewModel(router: Router) = SearchHotelNameViewModel(router)
}