package com.example.androidstarter.features.list.data.network

import com.example.androidstarter.features.list.data.network.dto.PlantDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PlantsApi {

    @GET("/plants")
    suspend fun getAllPlants(@Path("id") genus: String): List<PlantDto>
}