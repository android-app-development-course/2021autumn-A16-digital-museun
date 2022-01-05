package com.example.digital_museun

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_museum.*


class museum : Fragment(), View.OnClickListener{

    var height = 952

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // 设置点击事件
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_museum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detail_ejp.setOnClickListener {
            Log.d("sda","asd")
            startActivity(Intent(context,relicDetail::class.java))
        }
        henan_museum!!.setOnClickListener(this)
        detail_henan_museum!!.visibility = View.GONE
    }

    // 获取组件高度
    fun initOnPreDrawListener(){
        val viewTreeObserver = activity?.window!!.decorView.viewTreeObserver
        viewTreeObserver?.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                height = detail_henan_museum!!.measuredHeight
                Log.e("heightinit",height.toString())
                // 移除OnPreDrawListener事件监听
                this@museum.activity?.window?.decorView?.viewTreeObserver?.removeOnPreDrawListener(this)

                //获取完高度后隐藏控件
                detail_henan_museum!!.visibility = View.GONE
                return true
            }
        })
    }
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.henan_museum -> if (detail_henan_museum!!.visibility == View.GONE) {
                    //调用开始的方法
                    Log.d("height", height.toString())
                    start()
                } else {
                    //调用结束的方法
                    end()
                }
            }
        }
    }

    private  fun start(){
        // 显示控件
        detail_henan_museum!!.visibility = View.VISIBLE

        //开启平移动画
        val startTranslateAnim = TranslateAnimation(0F, 0F, (-height).toFloat(), 0F)
        Log.d("",height.toString())
        startTranslateAnim.duration = 500

        //控件开始动画
        detail_henan_museum!!.startAnimation(startTranslateAnim)
        expect_henan!!.startAnimation(startTranslateAnim)

        //开启动画的监听
        startTranslateAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                //动画开始调用
            }

            override fun onAnimationEnd(animation: Animation) {
                //动画结束时调用
            }

            override fun onAnimationRepeat(animation: Animation) {
                //动画重复时调用
            }
        })
    }

    private fun end() {
        height=detail_henan_museum.measuredHeight
        // 隐藏控件
//        detail_henan_museum!!.visibility = View.GONE

        // 关闭平移动画
        val endTranslateAnim = TranslateAnimation(0F, 0F, 0F, (-height).toFloat())
        endTranslateAnim.duration = 500

        //控件开始动画
        detail_henan_museum!!.startAnimation(endTranslateAnim)
        expect_henan!!.startAnimation(endTranslateAnim)
        //关闭动画的监听
        endTranslateAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                //动画开始调用
            }

            override fun onAnimationEnd(animation: Animation) {
                //动画结束时调用
                detail_henan_museum!!.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation) {
                //动画重复时调用
            }
        })
    }



}
