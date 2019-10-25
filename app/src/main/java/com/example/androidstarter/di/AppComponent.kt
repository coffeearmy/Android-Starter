package com.example.androidstarter.di

import android.content.Context
import com.example.androidstarter.features.list.di.ListModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ListModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}
