package com.example.nytimes.util

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri

class Utils {
companion object{
    fun openBrowser(url: String?): Intent? {
        return try {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        } catch (e: ActivityNotFoundException) {
           e.printStackTrace()
            null
        }
    }
}
}