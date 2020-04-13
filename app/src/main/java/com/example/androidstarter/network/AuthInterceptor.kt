package com.example.androidstarter.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class AuthInterceptor @Inject constructor(@Named("apiKey") private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val originalHttpUrl: HttpUrl = request.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("client_id", apiKey)
            .build()

        request = request?.newBuilder()
            ?.url(url)
            ?.build()

        return chain.proceed(request)
    }
}