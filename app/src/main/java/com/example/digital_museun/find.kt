package com.example.digital_museun

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class find : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#e8d8be")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)
    }
}