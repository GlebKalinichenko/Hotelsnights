package com.example.knifestart.data.searchhotellocatiion

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.api.IRemoteApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class DatabaseSearchHotelLocationDataSource @Inject constructor(var remoteApi: IRemoteApi) : ISearchHotelLocationDataSource {

    override fun fetchHotel(lat: Double, lng: Double): Observable<MutableList<Hotel>> = Observable.empty()
}