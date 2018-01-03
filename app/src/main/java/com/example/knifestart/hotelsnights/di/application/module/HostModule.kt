package com.example.knifestart.hotelsnights.di.application.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class HostModule {
    val NETWORK_TIMEOUT_SECONDS = 60L

    @Provides
    @Singleton
    fun provideBaseUrl() = "http://engine.hotellook.com/api/"

    @Provides
    @Singleton
    fun provideNetworkTimeout() = NETWORK_TIMEOUT_SECONDS
}