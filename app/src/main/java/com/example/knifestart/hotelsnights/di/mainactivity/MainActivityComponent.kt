package com.example.knifestart.hotelsnights.di.mainactivity

import com.example.knifestart.hotelsnights.MainActivity
import com.example.knifestart.hotelsnights.di.scope.HotelActivityScope
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

    //fun searchHotelNameComponentModule(): ListPostsComponent.Builder
    fun inject(activity: MainActivity)
}