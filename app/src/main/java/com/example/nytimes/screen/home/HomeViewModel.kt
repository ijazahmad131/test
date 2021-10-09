package com.example.nytimes.screen.home

import android.app.AlertDialog
import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.nytimes.data.model.NYTimesResponse
import com.example.nytimes.data.repository.HomeRepository
import com.example.nytimes.data.source.HomeDataSource
import java.util.*

class HomeViewModel(private val applicationContext: Application,
                    private val repository: HomeRepository
):AndroidViewModel(applicationContext) {
    var key : String? = null
    var isLoading = ObservableField(false)
    lateinit var newsList : (NYTimesResponse) -> Unit
fun mostPopular() {
    viewModel.isLoading.set(true)
    key = "Ttc3o1CA6buGRKTksgDAIG5mp69ffrX7"
    repository.mostPopular(key?:"",object : HomeDataSource.RemoteDataSource.ApiCallback{
        override fun onSucces(response: NYTimesResponse) {
           newsList.invoke(response)
        }

        override fun onFailure(message: String) {
            Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
        }
    })
}
}