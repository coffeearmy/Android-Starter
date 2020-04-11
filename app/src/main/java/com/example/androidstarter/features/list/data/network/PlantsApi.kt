package com.example.androidstarter.features.list.data.network

import com.example.androidstarter.features.list.data.network.dto.PlantDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlantsApi {

    @GET("plants")
    suspend fun getAllPlants(@Query("q") genus: String): List<PlantDto>
}