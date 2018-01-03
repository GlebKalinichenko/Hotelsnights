package com.example.knifestart.data.wrapper

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.response.HotelResponse
import com.example.knifestart.domain.response.HotelResultReponse
import com.example.knifestart.domain.response.HotelsResponse
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelNameWrapper @Inject constructor() {

    fun convertHotelReponse(hotelResponse: HotelResponse) : Hotel {
        var hotel = Hotel(hotelResponse.locationId, hotelResponse.fullName, hotelResponse.label, hotelResponse._score,
                hotelResponse.id, hotelResponse.locationName)
        return hotel
    }

    fun convertHotelsReponse(hotelResponses: HotelResultReponse) : MutableList<Hotel> {
        var hotels = mutableListOf<Hotel>()

        for (hotelResponse in hotelResponses.results.locations) {
            var locationId = hotelResponse.locationId ?: -1
            var fullName = hotelResponse.fullName ?: ""
            var label = hotelResponse.label ?: ""
            var score = hotelResponse._score ?: -1.0
            var id = hotelResponse.id ?: ""
            var locationName = hotelResponse.locationName ?: ""

            hotels.add(Hotel(locationId, fullName, label, score, id, locationName))
        }

        return hotels
    }
}