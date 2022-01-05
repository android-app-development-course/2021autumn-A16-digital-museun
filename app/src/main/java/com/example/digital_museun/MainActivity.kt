package com.example.digital_museun

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.digital_museun.my
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private val mTab01: Fragment = explore()
    private val mTab02: Fragment = community()
    private val mTab03: Fragment = treasureCabinet()
    private val mTab04: Fragment = museum()
    private val mTab05: Fragment = my()
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#e8d8be")


        Log.d("1","1")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.d("2","2")
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        Log.d("3","3")
        setContentView(R.layout.activity_main)

        initFragment()
        //initView()
        initEvent()

        val id = intent.getIntExtra("id",0)
        selectFragment(id)
    }

    //添加界面
    private fun initFragment() {
        Log.d("4","4")
        var fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.add(R.id.fragment_container, mTab01)
        transaction.add(R.id.fragment_container, mTab02)
        transaction.add(R.id.fragment_container, mTab03)
        transaction.add(R.id.fragment_container, mTab04)
        transaction.add(R.id.fragment_container, mTab05)
        transaction.commit()
    }

    private fun selectFragment(i: Int) {
        Log.d("5","5")
        var fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()
        hideFragment(transaction)
        when (i) {
            0 -> {
                Log.d("setSelect", "1")
                quanziImage!!.setBackgroundResource(R.drawable.quanzi1)
                cangbaogeImage!!.setBackgroundResource(R.drawable.cangbaoge1)
                bowuguanImage!!.setBackgroundResource(R.drawable.bowuguan1)
                myIamge!!.setBackgroundResource(R.drawable.my1)
                tansuoImage!!.setBackgroundResource(R.drawable.tansuo2)
                transaction.show(mTab01)
            }
            1 -> {
                tansuoImage!!.setBackgroundResource(R.drawable.tansuo1)
                cangbaogeImage!!.setBackgroundResource(R.drawable.cangbaoge1)
                bowuguanImage!!.setBackgroundResource(R.drawable.bowuguan1)
                myIamge!!.setBackgroundResource(R.drawable.my1)
                quanziImage!!.setBackgroundResource(R.drawable.quanzi2)
                transaction.show(mTab02)
            }
            2 -> {
                tansuoImage!!.setBackgroundResource(R.drawable.tansuo1)
                quanziImage!!.setBackgroundResource(R.drawable.quanzi1)
                bowuguanImage!!.setBackgroundResource(R.drawable.bowuguan1)
                myIamge!!.setBackgroundResource(R.drawable.my1)
                cangbaogeImage!!.setBackgroundResource(R.drawable.cangbaoge2)
                transaction.show(mTab03)
            }
            3 -> {
                tansuoImage!!.setBackgroundResource(R.drawable.tansuo1)
                quanziImage!!.setBackgroundResource(R.drawable.quanzi1)
                cangbaogeImage!!.setBackgroundResource(R.drawable.cangbaoge1)
                myIamge!!.setBackgroundResource(R.drawable.my1)
                bowuguanImage!!.setBackgroundResource(R.drawable.bowuguan2)
                transaction.show(mTab04)
            }
            4 -> {
                tansuoImage!!.setBackgroundResource(R.drawable.tansuo1)
                quanziImage!!.setBackgroundResource(R.drawable.quanzi1)
                cangbaogeImage!!.setBackgroundResource(R.drawable.cangbaoge1)
                bowuguanImage!!.setBackgroundResource(R.drawable.bowuguan1)
                myIamge!!.setBackgroundResource(R.drawable.my2)
                transaction.show(mTab05)
            }
            else -> {
            }
        }
        transaction.commit()
    }

    private fun initEvent() {
        Log.d("6","6")
        tansuoImage.setOnClickListener(this)
        quanziImage.setOnClickListener(this)
        cangbaogeImage.setOnClickListener(this)
        bowuguanImage.setOnClickListener(this)
        myIamge.setOnClickListener(this)
        Log.d("6","666")
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        Log.d("7","7")
        transaction.hide(mTab01)
        transaction.hide(mTab02)
        transaction.hide(mTab03)
        transaction.hide(mTab04)
        transaction.hide(mTab05)
    }

    override fun onClick(v: View?) {
        Log.d("8","8")
        Log.d("onClick", "1")
        when (v?.id) {
            R.id.tansuoImage -> {
                Log.d("onClick", "2")
                selectFragment(0)
            }
            R.id.quanziImage -> selectFragment(1)
            R.id.cangbaogeImage -> selectFragment(2)
            R.id.bowuguanImage -> selectFragment(3)
            R.id.myIamge -> selectFragment(4)
            else -> {
            }
        }
    }
}