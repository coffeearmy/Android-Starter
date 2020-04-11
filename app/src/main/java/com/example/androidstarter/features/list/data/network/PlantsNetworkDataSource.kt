package com.example.androidstarter.features.list.data.network

import com.example.androidstarter.features.list.data.network.mapper.PlantsMapper
import com.example.androidstarter.features.list.domain.model.Plant
import javax.inject.Inject

class PlantsNetworkDataSource @Inject constructor(
    private val plantApi: PlantsApi,
    private val plantsMapper: PlantsMapper){
    suspend fun getPlants(genus: String): List<Plant> {
        return plantApi.getAllPlants(genus).map { plantsMapper.mapToModel(it) }
    }
}