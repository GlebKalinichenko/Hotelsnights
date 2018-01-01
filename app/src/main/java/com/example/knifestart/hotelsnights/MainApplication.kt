package com.example.knifestart.hotelsnights

import android.app.Application
import com.example.knifestart.hotelsnights.di.application.component.ApplicationComponent
import com.example.knifestart.hotelsnights.di.application.component.DaggerApplicationComponent
import com.example.knifestart.hotelsnights.di.application.module.ApplicationModule

/**
 * Created by glebkalinichenko on 01.01.18.
 */
class MainApplication : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        
    }
}