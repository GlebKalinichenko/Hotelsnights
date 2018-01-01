package com.example.knifestart.domain

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by glebkalinichenko on 01.01.18.
 */
interface IRemoteApi {
    @GET("top.json")
    fun fetchPosts(@Query("limit") limit: String) : Observable<Hotel>
}