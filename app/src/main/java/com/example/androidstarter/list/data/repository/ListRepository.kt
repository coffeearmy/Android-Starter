package com.example.androidstarter.list.data.repository

import com.example.androidstarter.list.data.network.ListNetworkDataSource
import com.example.androidstarter.list.domain.model.Entry
import javax.inject.Inject

class ListRepository  @Inject constructor(private val listNetworkDataSource: ListNetworkDataSource) {
    suspend fun getSearchResults(color: String): List<Entry> {
        return listNetworkDataSource.getSearchResults(color)
    }
}