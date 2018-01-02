package com.example.knifestart.data.searchhotelname.datasource

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.api.IRemoteApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class DatabaseSearchHotelNameDataSource @Inject constructor(var remoteApi: IRemoteApi) : ISearchHotelNameDataSource {

    override fun fetchHotel(limit: Int): Observable<MutableList<Hotel>> = Observable.empty()
}