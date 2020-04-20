package com.example.androidstarter.list.domain.usecase

import com.example.androidstarter.list.data.repository.ListRepository
import javax.inject.Inject

class GetListItemsUseCase @Inject constructor(private val plantsRepository: ListRepository) {
    suspend fun invoke(color: String) = plantsRepository.getSearchResults(color)
}