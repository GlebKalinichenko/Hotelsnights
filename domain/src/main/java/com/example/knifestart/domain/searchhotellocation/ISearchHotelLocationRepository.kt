package com.example.knifestart.domain.searchhotellocation

import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable
import java.util.*

/**
 * Created by glebkalinichenko on 02.01.18.
 */
interface ISearchHotelLocationRepository {
    fun fetchHotelsLocationApi(lat: Double, lng: Double): Observable<MutableList<Hotel>>
    fun fetchHotelsLocationDatabase(lat: Double, lng: Double): Observable<MutableList<Hotel>>

}