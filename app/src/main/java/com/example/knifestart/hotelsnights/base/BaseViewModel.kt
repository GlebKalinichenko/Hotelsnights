package com.example.knifestart.hotelsnights.base

/**
 * Created by glebkalinichenko on 01.01.18.
 */
interface BaseViewModel {
    val LOG_TAG: String
        get() = this.javaClass.canonicalName

    fun dispose()
}