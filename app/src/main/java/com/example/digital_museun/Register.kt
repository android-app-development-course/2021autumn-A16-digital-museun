package com.example.digital_museun

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#e8d8be")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        back_to_login_by_password.setOnClickListener {
            finish()
        }
    }
}