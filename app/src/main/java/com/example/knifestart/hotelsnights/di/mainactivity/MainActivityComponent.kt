package com.example.knifestart.hotelsnights.di.mainactivity

import com.example.knifestart.hotelsnights.MainActivity
import com.example.knifestart.hotelsnights.di.scope.HotelActivityScope
import com.example.knifestart.hotelsnights.di.searchhotelname.SearchHotelNameComponent
import dagger.Subcomponent

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@HotelActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun mainActivityModule(mainActivityModule: MainActivityModule): Builder
        fun build(): MainActivityComponent
    }

    fun searchHotelNameComponent(): SearchHotelNameComponent.Builder
    fun inject(activity: MainActivity)
}