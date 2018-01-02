package com.example.knifestart.hotelsnights.searchhotelbyname

import com.example.knifestart.domain.searchhotelname.SearchHotelNameUseCase
import com.example.knifestart.hotelsnights.base.FragmentViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 01.01.18.
 */
class SearchHotelNameViewModel @Inject constructor(var router: Router, var fetchHotelUseCase: SearchHotelNameUseCase) : FragmentViewModel() {

}