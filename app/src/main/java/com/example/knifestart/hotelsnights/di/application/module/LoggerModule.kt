package com.example.knifestart.hotelsnights.di.application.module

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class LoggerModule {

    @Provides
    @Singleton
    fun provideLogger() : HttpLoggingInterceptor = HttpLoggingInterceptor()
}