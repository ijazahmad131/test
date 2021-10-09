package com.test.mvvmkotlinexample.data.remote

import android.annotation.SuppressLint
import com.example.nytimes.data.model.NYTimesResponse
import com.example.nytimes.data.source.HomeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class HomeRemoteDataSource : HomeDataSource.RemoteDataSource{
    companion object{
        @Volatile
        private  var instance:HomeRemoteDataSource? = null
    fun getInstance():HomeRemoteDataSource{
        if (instance == null){
            synchronized(HomeRemoteDataSource::class.java){
                if (instance == null){
                    instance = HomeRemoteDataSource()
                }
            }
        }
        return instance!!
    }
    }

    override fun mostPopular(
        key: String,
        homeCallback: HomeDataSource.RemoteDataSource.ApiCallback
    ) {
        ApiService.getInstance()?.mostPopular(key)?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())?.subscribe(
          fun (result: NYTimesResponse){
              onSuccess(result, homeCallback)
          },
            fun (error:Throwable){
                onFailure(error, homeCallback)
            }
        )
    }

    private fun onFailure(
        error: Throwable,
        homeCallback: HomeDataSource.RemoteDataSource.ApiCallback
    ) {
        homeCallback.onFailure(error.message!!)
    }

    private fun onSuccess(response: NYTimesResponse, homeCallback: HomeDataSource.RemoteDataSource.ApiCallback) {
        homeCallback.onSucces(response)
    }
}