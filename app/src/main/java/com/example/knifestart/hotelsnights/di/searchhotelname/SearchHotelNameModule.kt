package com.example.knifestart.hotelsnights.di.searchhotelname

import com.example.knifestart.data.searchhotelname.repository.SearchHotelNameRepository
import com.example.knifestart.domain.searchhotelname.SearchHotelNameUseCase
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

    @Provides @HotelScope
    fun provideSearchHotelNameUseCase(postRepository: SearchHotelNameRepository) : SearchHotelNameUseCase =
            SearchHotelNameUseCase(Schedulers.io(), AndroidSchedulers.mainThread(), postRepository)

    @Provides @HotelScope
    fun provideViewModel(router: Router, useCase: SearchHotelNameUseCase) = SearchHotelNameViewModel(router, useCase)
}