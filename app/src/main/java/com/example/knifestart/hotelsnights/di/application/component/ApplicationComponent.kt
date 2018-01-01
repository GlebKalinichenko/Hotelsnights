package com.example.knifestart.hotelsnights.di.application.component

import com.example.knifestart.hotelsnights.MainApplication
import com.example.knifestart.hotelsnights.di.application.module.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 01.01.18.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, GsonModule::class, HostModule::class,
        LoggerModule::class, NetworkModule::class, NavigationModule::class))
interface ApplicationComponent {
    //fun postComponentModule(): PostContainerComponent.Builder
    fun inject(app: MainApplication)
}