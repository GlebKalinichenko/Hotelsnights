package com.example.knifestart.domain.api

import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by glebkalinichenko on 01.01.18.
 */
interface IRemoteApi {
    @GET("top.json")
    fun fetchHotels(@Query("limit") limit: String) : Observable<Hotel>

    @GET("top.json")
    fun fetchHotels(@Query("lat") lat: String, @Query("lng") lng: String) : Observable<Hotel>
}