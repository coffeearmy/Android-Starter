package com.example.androidstarter.list.di

import com.example.androidstarter.di.PerActivity
import com.example.androidstarter.ui.ListActivity
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