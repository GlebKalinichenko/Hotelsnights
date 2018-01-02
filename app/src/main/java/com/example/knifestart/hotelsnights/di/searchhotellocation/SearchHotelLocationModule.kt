package com.example.knifestart.hotelsnights.di.searchhotellocation

import com.example.knifestart.data.searchhotellocatiion.SearchHotelLocationRepository
import com.example.knifestart.domain.searchhotellocation.SearchHotelLocationUseCase
import com.example.knifestart.hotelsnights.di.scope.HotelScope
import com.example.knifestart.hotelsnights.searchhotelbylocation.SearchHotelLocationViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router

/**
 * Created by glebkalinichenko on 02.01.18.
 */
@Module
class SearchHotelLocationModule {
    @Provides @HotelScope
    fun provideUseCase(repository: SearchHotelLocationRepository) = SearchHotelLocationUseCase(Schedulers.io(), AndroidSchedulers.mainThread(), repository)

    @Provides @HotelScope
    fun provideViewModel(router: Router, useCase: SearchHotelLocationUseCase) = SearchHotelLocationViewModel(router, useCase)
}