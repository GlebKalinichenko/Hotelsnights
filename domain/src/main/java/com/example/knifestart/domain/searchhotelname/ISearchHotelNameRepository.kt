package com.example.knifestart.domain.searchhotelname

import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable

/**
 * Created by glebkalinichenko on 02.01.18.
 */
interface ISearchHotelNameRepository {
    fun fetchHotelsApi(query: String, limit: Int) : Observable<MutableList<Hotel>>
    fun fetchHotelsDatabase(query: String, limit: Int) : Observable<MutableList<Hotel>>
}