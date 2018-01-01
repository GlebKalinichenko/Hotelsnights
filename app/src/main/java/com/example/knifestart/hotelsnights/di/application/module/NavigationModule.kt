package com.example.knifestart.hotelsnights.di.application.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Module
class NavigationModule constructor(var cicerone: Cicerone<Router> = Cicerone.create()) {
    @Provides
    @Singleton
    fun provideRouter(): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(): NavigatorHolder = cicerone.navigatorHolder
}