package com.example.nytimes.util

import android.content.Context
import com.example.nytimes.data.repository.HomeRepository
import com.test.mvvmkotlinexample.data.remote.HomeRemoteDataSource
import io.reactivex.annotations.NonNull

class InjectionUtils {
    companion object{
        fun provideHomeRepository(@NonNull context: Context): HomeRepository {
            return HomeRepository.getInstance(HomeRemoteDataSource.getInstance())
        }
    }
}