package com.example.knifestart.hotelsnights.di.application.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module @Singleton
class ApplicationModule (var context: Context) {

    @Provides @Singleton
    fun provideApplication() = context
}