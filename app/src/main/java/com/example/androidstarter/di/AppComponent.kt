package com.example.androidstarter.di

import android.content.Context
import com.example.androidstarter.list.di.ListComponent
import com.example.androidstarter.list.di.ListModule
import com.example.androidstarter.list.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ListModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun listComponent(): ListComponent.Factory

}
