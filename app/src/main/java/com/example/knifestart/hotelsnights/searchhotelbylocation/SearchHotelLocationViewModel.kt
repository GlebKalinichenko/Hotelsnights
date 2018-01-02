package com.example.knifestart.hotelsnights.searchhotelbylocation

import com.example.knifestart.domain.searchhotellocation.SearchHotelLocationUseCase
import com.example.knifestart.hotelsnights.base.FragmentViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 01.01.18.
 */
class SearchHotelLocationViewModel @Inject constructor(val router: Router, val searchLocationUseCase: SearchHotelLocationUseCase) : FragmentViewModel() {

}