package com.example.androidstarter.features.list.di

import com.example.androidstarter.di.PerActivity
import com.example.androidstarter.features.list.ui.ListActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent
interface ListComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ListComponent
    }

    fun inject(activity: ListActivity)
}