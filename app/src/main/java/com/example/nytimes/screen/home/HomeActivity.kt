package com.example.nytimes.screen.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimes.R
import com.example.nytimes.data.model.ResultsItem
import com.example.nytimes.util.ExtFunctions.getViewModel
import com.example.nytimes.util.InjectionUtils
import com.example.nytimes.util.Utils
import kotlinx.android.synthetic.main.activity_home.*

lateinit var viewModel: HomeViewModel
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setViewModel()
        viewModel.mostPopular()
    }

    private fun setViewModel() {
        viewModel = getViewModel{
            HomeViewModel(application, InjectionUtils.provideHomeRepository(applicationContext))
        }
        viewModel.newsList = {
            if (it.results.isNullOrEmpty()){

            }else{
                setNewsAdapter(it.results)
            }
        }
    }

    private fun setNewsAdapter(results: List<ResultsItem>) {

        val adapter = HomeAdapter(results,object :HomeAdapter.ItemClickListener{
            override fun onItemClick(item: String) {
                val intent: Intent = Utils.openBrowser(item)!!
                intent.let { startActivity(it) }
            }
        })
        rvItems.setAdapter(adapter)
    }
}