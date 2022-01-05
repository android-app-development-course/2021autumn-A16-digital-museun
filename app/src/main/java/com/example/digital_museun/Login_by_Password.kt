package com.example.digital_museun

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_by_password.*

class Login_by_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#e8d8be")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_by_password)

        turn_to_register.setOnClickListener {
            intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}