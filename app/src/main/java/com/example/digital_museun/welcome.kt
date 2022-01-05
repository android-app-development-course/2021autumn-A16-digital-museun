package com.example.digital_museun

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#B9AD97")
        setContentView(R.layout.activity_welcome)
        val myThread: Thread = object : Thread() {
            //创建子线程
            override fun run() {
                try {
                    sleep(2500) //使程序休眠五秒
                    val it = Intent(applicationContext, MainActivity::class.java) //启动MainActivity
                    startActivity(it)
                    finish() //关闭当前活动
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        myThread.start() //启动线程
    }
}