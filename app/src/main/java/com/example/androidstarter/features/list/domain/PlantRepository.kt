package com.example.androidstarter.features.list.domain

import com.example.androidstarter.features.list.data.PlantsApi
import javax.inject.Inject

class PlantRepository  @Inject constructor(private val plantApi: PlantsApi, private val plantsMapper: PlantsMapper) {
    suspend fun getPlants(): List<Plant> {
        return plantApi.getAllPlants("plantica").map { plantsMapper.mapToModel(it) }
    }
}