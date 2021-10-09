package com.example.nytimes.screen.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimes.R
import com.example.nytimes.screen.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val i: Intent = Intent(this,HomeActivity::class.java)
        startActivity(i)
    }
}