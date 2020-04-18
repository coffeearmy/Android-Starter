package com.example.androidstarter.di

import android.content.Context
import com.example.androidstarter.BuildConfig
import com.example.androidstarter.R
import com.example.androidstarter.features.list.data.network.SearchApi
import com.example.androidstarter.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideNetworkClient(authInterceptor: AuthInterceptor): Retrofit{
        val baseUrl ="https://api.unsplash.com/"
        val loggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }

        val okHttpClient = OkHttpClient().newBuilder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
    @Singleton
    @Provides
    @Named("apiKey")
    internal fun provideApiKey(context: Context): String{
        return context.getString(R.string.api_key)
    }

    @Singleton
    @Provides
    fun provideListRestClient(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }
}