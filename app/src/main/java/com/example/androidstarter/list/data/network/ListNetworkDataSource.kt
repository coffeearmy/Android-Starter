package com.example.androidstarter.list.data.network

import com.example.androidstarter.list.data.network.mapper.SearchMapper
import com.example.androidstarter.list.domain.model.Entry
import javax.inject.Inject

class ListNetworkDataSource @Inject constructor(
    private val searchApi: SearchApi,
    private val searchMapper: SearchMapper
) {
    suspend fun getSearchResults(color: String): List<Entry> {
        return searchApi.searchItems("flower",color).results.map {searchMapper.mapToModel(it) }
    }
}