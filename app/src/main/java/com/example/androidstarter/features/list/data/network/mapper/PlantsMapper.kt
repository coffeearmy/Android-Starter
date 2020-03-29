package com.example.androidstarter.features.list.data.network.mapper

import com.example.androidstarter.features.list.data.network.dto.PlantDto
import com.example.androidstarter.features.list.domain.model.Plant

class PlantsMapper {

    fun mapToModel(plantDto: PlantDto): Plant {
        return Plant()
    }
}
