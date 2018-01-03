package com.example.knifestart.domain.api

import com.example.knifestart.domain.response.HotelResultReponse
import com.example.knifestart.domain.response.HotelsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by glebkalinichenko on 01.01.18.
 */
interface IRemoteApi {
    @GET("v2/lookup.json")
    fun fetchHotels(@Query("query") query: String, @Query("lang") lang: String, @Query("lookup") lookup: String,
        @Query("limit") limit: Int) : Observable<HotelResultReponse>
}