package com.example.androidstarter.features.list.di

import com.example.androidstarter.di.PerApp
import com.example.androidstarter.features.list.data.network.PlantsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ListModule{

    @Provides
    @PerApp
    fun provideListRestClient(retrofit: Retrofit): PlantsApi {
        return retrofit.create(PlantsApi::class.java)
    }
}