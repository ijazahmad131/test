package com.example.nytimes.data.repository

import com.example.nytimes.data.source.HomeDataSource


class HomeRepository internal constructor(private val remoteDatasource: HomeDataSource.RemoteDataSource):
    HomeDataSource.RemoteDataSource{
    companion object{
        @Volatile
        private var instance:HomeRepository? = null
        fun getInstance(remoteDatasource:HomeDataSource.RemoteDataSource):HomeRepository{
            if (instance == null){
                synchronized(HomeRepository::class.java){
                    if (instance == null){
                        instance = HomeRepository(remoteDatasource)
                    }
                }
            }
            return instance!!
        }
    }

    override fun mostPopular(
        key: String,
        callback: HomeDataSource.RemoteDataSource.ApiCallback
    ) {
        remoteDatasource.mostPopular(key, callback)
    }




}
