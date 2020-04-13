package com.example.androidstarter.features.list.di

import com.example.androidstarter.features.list.data.network.SearchApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ListModule{

    @Provides
    fun provideListRestClient(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }
}