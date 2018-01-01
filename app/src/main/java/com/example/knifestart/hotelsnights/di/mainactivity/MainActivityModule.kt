package com.example.knifestart.hotelsnights.di.mainactivity

import com.example.knifestart.hotelsnights.di.scope.HotelActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class MainActivityModule {
    @Provides
    @HotelActivityScope
    fun provideTest() = ""
}