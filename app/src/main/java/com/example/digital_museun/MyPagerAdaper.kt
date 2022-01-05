package com.example.digital_museun

import android.view.View
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.ArrayList

class MyPagerAdaper : PagerAdapter {
    private var mViewlist: ArrayList<View>? = null
    private var mtitlelist: ArrayList<String>? = null

    constructor() {}
    constructor(viewlist: ArrayList<View>?, mtitlelist: ArrayList<String>?) {
        viewlist.also { mViewlist = it }
        this.mtitlelist = mtitlelist

    }

    override fun getCount(): Int {
        return mViewlist!!.size //返回view数组大小
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(mViewlist!![position])

        return mViewlist!![position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(mViewlist!![position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mtitlelist!![position]
    }
}