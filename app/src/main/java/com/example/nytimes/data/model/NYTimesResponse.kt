package com.example.nytimes.data.model

import com.google.gson.annotations.SerializedName

data class NYTimesResponse(@SerializedName("copyright")
                           val copyright: String = "",
                           @SerializedName("results")
                           val results: List<ResultsItem>?,
                           @SerializedName("num_results")
                           val numResults: Int = 0,
                           @SerializedName("status")
                           val status: String = "")