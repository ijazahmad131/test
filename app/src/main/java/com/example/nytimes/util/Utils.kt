package com.example.nytimes.util

import com.example.nytimes.data.model.MediaItem

class Utils {
companion object{
    fun isNullOrEmpty(list: List<*>?): Boolean {
        return list == null || list.size == 0
    }
    const val STANDARD_THUMBNAIL = "Standard Thumbnail"
    fun getImageUrl(media: List<MediaItem>?): String? {
        if (isNullOrEmpty(media)) return ""
        if (isNullOrEmpty(media!!.get(0).mediaMetadata)) return ""
        for (item in media!!.get(0).mediaMetadata!!) {
            if (item.format.equals(STANDARD_THUMBNAIL,false)) {
                return item.url
            }
        }
        return ""
    }
}
}