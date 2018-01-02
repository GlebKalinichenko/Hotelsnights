package com.example.knifestart.data.searchhotellocatiion

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.searchhotellocation.ISearchHotelLocationRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelLocationRepository @Inject constructor(var factory: SearchHoteLocationFactory) : ISearchHotelLocationRepository {
    override fun fetchHotelsLocationDatabase(lat: Double, lng: Double): Observable<MutableList<Hotel>> = factory.fetchDatabaseApi().fetchHotel(lat, lng)

    override fun fetchHotelsLocationApi(lat: Double, lng: Double): Observable<MutableList<Hotel>> = factory.fetchRemoteApi().fetchHotel(lat, lng)
}