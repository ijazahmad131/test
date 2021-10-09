package com.example.nytimes.screen.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimes.R
import com.example.nytimes.data.model.ResultsItem
import com.example.nytimes.databinding.ActivityHomeBinding
import com.example.nytimes.util.ExtFunctions.getViewModel
import com.example.nytimes.util.InjectionUtils
import kotlinx.android.synthetic.main.activity_home.*

lateinit var viewModel: HomeViewModel
lateinit var binding : ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        setViewModel()
        viewModel.mostPopular()
    }

    private fun setViewModel() {
        viewModel = getViewModel{
            HomeViewModel(application, InjectionUtils.provideHomeRepository(applicationContext))
        }
        binding.viewModel = viewModel
        viewModel.newsList = {

            setNewsAdapter(it.results)
        }
    }

    private fun setNewsAdapter(results: List<ResultsItem>?) {
        viewModel.isLoading.set(false)
        val adapter = HomeAdapter(results!!,object :HomeAdapter.ItemClickListener{
            override fun onItemClick(item: String) {
                val intent: Intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(item)
                ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        })
        rvItems.setHasFixedSize(true)
        rvItems.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        rvItems.adapter = adapter
    }
}