package com.example.androidstarter.di

import javax.inject.Scope

@Target(AnnotationTarget.FUNCTION)
@Scope
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@kotlin.annotation.Target
annotation class PerApp
