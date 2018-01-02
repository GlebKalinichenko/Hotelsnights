package com.example.knifestart.data.wrapper

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.response.HotelResponse
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelNameWrapper @Inject constructor() {

    fun convertHotelReponse(hotelResponse: HotelResponse) : Hotel {
        var hotel = Hotel(hotelResponse.name)
        return hotel
    }

    fun convertHotelReponse(hotelResponses: List<HotelResponse>) : MutableList<Hotel> {
        var hotels = mutableListOf<Hotel>()

        for (hotelResponse in hotelResponses) {
            hotels.add(Hotel(hotelResponse.name))
        }

        return hotels
    }
}