package com.example.androidstarter.di

import android.content.Context
import com.example.androidstarter.features.list.di.ListModule
import com.example.androidstarter.features.list.ui.PlantListActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, ListModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(activity : PlantListActivity)
}
