package com.example.knifestart.hotelsnights.searchhotelbyname

/**
 * Created by glebkalinichenko on 02.01.18.
 */
interface ISearchHotelNameViewModel {
    fun searchHotels(query: String, limit: Int, isRefresh: Boolean)
    fun refreshHotels()
}