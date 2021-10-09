package com.example.nytimes.data.model

import com.example.nytimes.data.model.MediaItem
import com.google.gson.annotations.SerializedName

data class ResultsItem(@SerializedName("eta_id")
                       val etaId: Int = 0,
                       @SerializedName("subsection")
                       val subsection: String = "",
                       @SerializedName("org_facet")
                       val orgFacet: List<String>?,
                       @SerializedName("nytdsection")
                       val nytdsection: String = "",
                       @SerializedName("column")
                       val column: String? = null,
                       @SerializedName("section")
                       val section: String = "",
                       @SerializedName("asset_id")
                       val assetId: Long = 0,
                       @SerializedName("source")
                       val source: String = "",
                       @SerializedName("abstract")
                       val abstract: String = "",
                       @SerializedName("media")
                       val media: List<MediaItem>?,
                       @SerializedName("type")
                       val type: String = "",
                       @SerializedName("title")
                       val title: String = "",
                       @SerializedName("des_facet")
                       val desFacet: List<String>?,
                       @SerializedName("uri")
                       val uri: String = "",
                       @SerializedName("adx_keywords")
                       val adxKeywords: String = "",
                       @SerializedName("id")
                       val id: Long = 0,
                       @SerializedName("published_date")
                       val publishedDate: String = "",
                       @SerializedName("updated")
                       val updated: String = "",
                       @SerializedName("byline")
                       val byline: String = "")