package com.example.androidstarter.features.list.data.network.mapper

import com.example.androidstarter.features.list.data.network.dto.PlantDto
import com.example.androidstarter.features.list.domain.model.Plant
import javax.inject.Inject

class PlantsMapper @Inject constructor() {

    fun mapToModel(plantDto: PlantDto): Plant {
        return Plant(id = plantDto.id, name = plantDto.scientificName)
    }
}
