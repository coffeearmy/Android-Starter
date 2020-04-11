package com.example.androidstarter

import android.app.Application
import com.example.androidstarter.di.AppComponent
import com.example.androidstarter.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(applicationContext)
    }
}