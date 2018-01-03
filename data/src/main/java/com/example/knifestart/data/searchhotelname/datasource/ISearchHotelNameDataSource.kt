package com.example.knifestart.data.searchhotelname.datasource

import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable

/**
 * Created by glebkalinichenko on 02.01.18.
 */
interface ISearchHotelNameDataSource {
    fun fetchHotel(query: String, limit: Int) : Observable<MutableList<Hotel>>
}