package com.example.knifestart.data.searchhotelname.datasource

import com.example.knifestart.data.wrapper.SearchHotelNameWrapper
import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.api.IRemoteApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class RemoteSearchHotelNameDataSource @Inject constructor(var remoteApi: IRemoteApi, var wrapper: SearchHotelNameWrapper) : ISearchHotelNameDataSource {
    override fun fetchHotel(query: String, limit: Int): Observable<MutableList<Hotel>> =
            remoteApi.fetchHotels(query, "ru", "hotel", limit).flatMap { i -> Observable.just(wrapper.convertHotelsReponse(i)) }
}