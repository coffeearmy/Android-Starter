package com.example.androidstarter.features.list.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.androidstarter.ui.ListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListActivityTest{
    @get:Rule
    val activityRule = ActivityTestRule(ListActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(ListActivity::class.java)
    }

}