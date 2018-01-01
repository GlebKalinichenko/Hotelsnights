package com.example.knifestart.hotelsnights.di.searchhotelname

import com.example.knifestart.hotelsnights.di.scope.HotelScope
import com.example.knifestart.hotelsnights.searchhotelbyname.SearchHotelNameFragment
import dagger.Subcomponent

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@HotelScope @Subcomponent(modules = arrayOf(SearchHotelNameModule::class))
interface SearchHotelNameComponent {

    @Subcomponent.Builder
    interface Builder {
        fun searchNameModule(searchHotelNameModule: SearchHotelNameModule) : Builder
        fun build(): SearchHotelNameComponent
    }

    fun inject(searchHotelNameFragment: SearchHotelNameFragment)
}