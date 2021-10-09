package com.example.nytimes.data.model

import com.google.gson.annotations.SerializedName

data class MediaMetadataItem(@SerializedName("format")
                             val format: String = "",
                             @SerializedName("width")
                             val width: Int = 0,
                             @SerializedName("url")
                             val url: String = "",
                             @SerializedName("height")
                             val height: Int = 0)