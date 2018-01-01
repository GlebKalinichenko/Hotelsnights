package com.example.knifestart.hotelsnights.base

import com.example.knifestart.hotelsnights.base.BaseViewModel

/**
 * Created by glebkalinichenko on 01.01.18.
 */
interface IFragmentBaseViewModel : BaseViewModel {
    fun onCreateView()
    fun onStart()
    fun onDestroyView()
}