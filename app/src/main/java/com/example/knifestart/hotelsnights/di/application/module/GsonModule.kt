package com.example.knifestart.hotelsnights.di.application.module

import com.bumptech.glide.load.model.ByteArrayLoader
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class GsonModule {

    @Provides @Singleton
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides @Singleton
    fun provideGsonConverter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)
}