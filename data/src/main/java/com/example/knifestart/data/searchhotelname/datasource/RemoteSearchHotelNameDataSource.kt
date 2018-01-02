package com.example.knifestart.data.searchhotelname.datasource

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.api.IRemoteApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class RemoteSearchHotelNameDataSource @Inject constructor(var remoteApi: IRemoteApi) : ISearchHotelDataSource {

    override fun fetchHotel(limit: Int): Observable<MutableList<Hotel>> = Observable.empty()
}