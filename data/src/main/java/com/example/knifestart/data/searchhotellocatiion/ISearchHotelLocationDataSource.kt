package com.example.knifestart.data.searchhotellocatiion

import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable

/**
 * Created by glebkalinichenko on 02.01.18.
 */
interface ISearchHotelLocationDataSource {
    fun fetchHotel(lat: Double, lng: Double) : Observable<MutableList<Hotel>>
}