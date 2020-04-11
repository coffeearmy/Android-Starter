package com.example.androidstarter.features.list.di

import androidx.lifecycle.ViewModel
import com.example.androidstarter.di.PerApp
import com.example.androidstarter.di.ViewModelKey
import com.example.androidstarter.features.list.data.network.PlantsApi
import com.example.androidstarter.features.list.ui.PlantListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
class ListModule{

    @Provides
    fun provideListRestClient(retrofit: Retrofit): PlantsApi {
        return retrofit.create(PlantsApi::class.java)
    }
}