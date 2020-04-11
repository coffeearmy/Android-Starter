package com.example.androidstarter.features.list.domain.usecase

import com.example.androidstarter.features.list.data.repository.PlantRepository
import javax.inject.Inject

class GetPlantsUseCase @Inject constructor(private val plantsRepository: PlantRepository) {
    suspend fun invoke(genus: String) = plantsRepository.getPlants(genus)
}