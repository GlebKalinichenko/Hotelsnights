package com.example.knifestart.hotelsnights.di.searchhotellocation

import com.example.knifestart.hotelsnights.di.scope.HotelScope
import com.example.knifestart.hotelsnights.searchhotelbylocation.SearchHotelLocationFragment
import com.example.knifestart.hotelsnights.searchhotelbyname.SearchHotelNameFragment
import dagger.Subcomponent

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@HotelScope @Subcomponent(modules = arrayOf(SearchHotelLocationModule::class))
interface SearchHotelLocationComponent {

    @Subcomponent.Builder
    interface Builder {
        fun searchLocationModule(searchHotelLocationModule: SearchHotelLocationModule) : Builder
        fun build(): SearchHotelLocationComponent
    }

    fun inject(searchHotelLocationFragment: SearchHotelLocationFragment)
}