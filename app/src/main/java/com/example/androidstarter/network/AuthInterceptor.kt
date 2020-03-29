package com.example.androidstarter.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor  : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val originalHttpUrl: HttpUrl = request.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("token", "UnhhOVp4b0luUCsydmF1eFlpN2Q4Zz09")
            .build()

        request = request?.newBuilder()
            ?.url(url)
            ?.build()

        return chain.proceed(request)
    }
}