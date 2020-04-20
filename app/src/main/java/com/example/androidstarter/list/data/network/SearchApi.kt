package com.example.androidstarter.list.data.network

import com.example.androidstarter.list.data.network.dto.SearchResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search/photos")
    suspend fun searchItems(
        @Query("query") term: String,
        @Query("color") color: String
    ): SearchResultDto
}