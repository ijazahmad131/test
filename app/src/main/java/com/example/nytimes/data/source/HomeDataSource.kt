package com.example.nytimes.data.source

import com.example.nytimes.data.model.NYTimesResponse


interface HomeDataSource {
    interface RemoteDataSource{
        fun mostPopular(
            key: String,
            callback: ApiCallback
        )

        interface ApiCallback{
            fun onSucces(response: NYTimesResponse)

            fun onFailure(message : String)
        }
    }
}