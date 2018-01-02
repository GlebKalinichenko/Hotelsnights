package com.example.knifestart.data.searchhotellocatiion

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 02.01.18.
 */
@Singleton
class SearchHoteLocationFactory @Inject constructor(private val remoteSearchHotelNameDataSource: RemoteSearchHotelLocationDataSource,
                                                    private val databaseSearchHotelNameDataSource: DatabaseSearchHotelLocationDataSource) {

    fun fetchRemoteApi() = remoteSearchHotelNameDataSource

    fun fetchDatabaseApi() = databaseSearchHotelNameDataSource
}