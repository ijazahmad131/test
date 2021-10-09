package com.test.mvvmkotlinexample.data.remote

import com.example.nytimes.data.model.NYTimesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import io.reactivex.Observable

interface ApiInterface {
    @GET("/svc/mostpopular/v2/mostviewed/all-sections/7.json?")
    fun mostPopular(@Query("api-key") key:String): Observable<NYTimesResponse>
}