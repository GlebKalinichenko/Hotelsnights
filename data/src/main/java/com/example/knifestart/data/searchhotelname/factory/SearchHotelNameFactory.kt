package com.example.knifestart.data.searchhotelname.factory

import com.example.knifestart.data.searchhotelname.datasource.DatabaseSearchHotelNameDataSource
import com.example.knifestart.data.searchhotelname.datasource.RemoteSearchHotelNameDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by glebkalinichenko on 02.01.18.
 */
@Singleton
class SearchHotelNameFactory @Inject constructor(val remoteSearchHotelNameDataSource: RemoteSearchHotelNameDataSource,
                                                 val databaseSearchHotelNameDataSource: DatabaseSearchHotelNameDataSource) {

    fun fetchRemoteApi() = remoteSearchHotelNameDataSource

    fun fetchDatabaseApi() = databaseSearchHotelNameDataSource
}