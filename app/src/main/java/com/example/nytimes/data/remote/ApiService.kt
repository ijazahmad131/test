package com.test.mvvmkotlinexample.data.remote

import com.example.nytimes.data.model.NYTimesResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import io.reactivex.Observable

class ApiService {
init {
    apiInterface = getRetrofit().create(ApiInterface::class.java)
}

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .client(getBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getBuilder():OkHttpClient.Builder{
        val builder= OkHttpClient.Builder()
            .connectTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
        builder.addInterceptor{chain ->
            chain.proceed(chain.request())
        }

        return builder
    }
    companion object{
        @Volatile
        private var INSTANCE :ApiService?  = null
        private lateinit var apiInterface: ApiInterface
        fun getInstance():ApiService?{
            if (INSTANCE == null) {
                synchronized(ApiService::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = ApiService()
                    }
                }
            }
            return INSTANCE
        }
    }

    fun mostPopular(key:String):Observable<NYTimesResponse> = apiInterface.mostPopular(key)
}