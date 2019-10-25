package com.example.androidstarter.features.list.domain

import com.example.androidstarter.features.list.data.PlantDto

class PlantsMapper {

    fun mapToModel(plantDto: PlantDto): Plant {
        return Plant()
    }
}
