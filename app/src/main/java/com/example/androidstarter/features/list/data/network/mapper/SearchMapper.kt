package com.example.androidstarter.features.list.data.network.mapper

import com.example.androidstarter.features.list.data.network.dto.ResultDto
import com.example.androidstarter.features.list.domain.model.Entry
import javax.inject.Inject

class SearchMapper @Inject constructor() {
    fun mapToModel(result: ResultDto): Entry {
        return Entry(
            id = result.id,
            username = result.user.username,
            height = result.height,
            width = result.width,
            color = result.color,
            regularUrl = result.urls.regular
        )
    }
}
