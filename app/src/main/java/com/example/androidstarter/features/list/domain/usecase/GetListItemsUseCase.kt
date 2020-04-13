package com.example.androidstarter.features.list.domain.usecase

import com.example.androidstarter.features.list.data.repository.ListRepository
import javax.inject.Inject

class GetListItemsUseCase @Inject constructor(private val plantsRepository: ListRepository) {
    suspend fun invoke(color: String) = plantsRepository.getSearchResults(color)
}