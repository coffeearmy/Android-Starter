package com.example.androidstarter

import android.app.Application
import com.example.androidstarter.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .factory()
            .create(applicationContext)
    }
}