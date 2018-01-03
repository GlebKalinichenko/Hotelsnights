package com.example.knifestart.data.searchhotelname.repository

import com.example.knifestart.data.searchhotelname.factory.SearchHotelNameFactory
import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.searchhotelname.ISearchHotelNameRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelNameRepository @Inject constructor(var factory: SearchHotelNameFactory)  : ISearchHotelNameRepository {

    override fun fetchHotelsApi(query: String, limit: Int): Observable<MutableList<Hotel>> = factory.fetchRemoteApi().fetchHotel(query, limit)

    override fun fetchHotelsDatabase(query: String, limit: Int): Observable<MutableList<Hotel>> = factory.fetchDatabaseApi().fetchHotel(query, limit)
}