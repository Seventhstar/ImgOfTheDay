package com.seventhstar.imgoftheday.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seventhstar.imgoftheday.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WishesFragment.newInstance())
                .commitNow()
        }
    }
}