package com.example.androidstarter.features.list.data.repository

import com.example.androidstarter.features.list.data.network.PlantsApi
import com.example.androidstarter.features.list.data.network.PlantsNetworkDataSource
import com.example.androidstarter.features.list.domain.model.Plant
import com.example.androidstarter.features.list.data.network.mapper.PlantsMapper
import javax.inject.Inject

class PlantRepository  @Inject constructor(private val plantsNetworkDataSource: PlantsNetworkDataSource) {
    suspend fun getPlants(): List<Plant> {
        return plantsNetworkDataSource.getPlants()
    }
}