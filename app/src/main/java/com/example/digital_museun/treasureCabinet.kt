package com.example.digital_museun

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.image
import kotlinx.android.synthetic.main.fragment_treasure_cabinet.*
import java.util.ArrayList


class treasureCabinet : Fragment() {

    private var mViews //存放视图的数组
            = ArrayList<View>()

    private lateinit var view1: View
    private lateinit var view2: View
    private lateinit var view3: View

    private var mtitle //存放标题的数组
            = ArrayList<String>()
    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf<String>(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private val imageList = ArrayList<image>()
    private val imageList_tang = ArrayList<image>()
    private val imageList_shang = ArrayList<image>()




    public val layoutManager = LinearLayoutManager(activity)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treasure_cabinet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initImage()

        var mViewPager= viewpager// 实例化viewpager控件
        val inflater = layoutInflater //获取布局对象管理
        view1 = inflater.inflate(R.layout.layout1, null) //实例化view
        view2 = inflater.inflate(R.layout.layout2, null)
        view3 = inflater.inflate(R.layout.layout3, null)
//        放视图
        mViews.add(view1)
        mViews.add(view2)
        mViews.add(view3)
//        放朝代名
        mtitle.add("唐")
        mtitle.add("元")
        mtitle.add("战国")

//        左右滑适配
        val mAdapter = MyPagerAdaper(mViews, mtitle) //实例化适配器
        mViewPager.adapter = mAdapter //设置适配器

//        View2适配
        val recycle_image: RecyclerView = view2.findViewById(R.id.recycle_image)
        adapt(recycle_image,imageList)
//        View1适配
        val recycle_image_1: RecyclerView = view1.findViewById(R.id.recycle_image)
        adapt(recycle_image_1,imageList_tang)
//        View3适配
        val recycle_image_3: RecyclerView = view3.findViewById(R.id.recycle_image)
        adapt(recycle_image_3,imageList_shang)

    }
    private fun adapt(recycle_image:RecyclerView,imagelist:ArrayList<image>){
        recycle_image.layoutManager = LinearLayoutManager(activity)
        val adapter = KotlinRecycleAdapter(imagelist)
        layoutManager.orientation
        recycle_image.adapter = adapter
        PagerSnapHelper().attachToRecyclerView(recycle_image)
    }

    private fun initImage(){
        imageList_tang.add(image("唐五代秘色瓷",R.drawable.tang_ci))
        imageList_tang.add(image("唐三彩骆驼载乐俑",R.drawable.tang_luo))


        imageList.add(image("卓冠群芳图",R.drawable.niao))
        imageList.add(image("元青花观音像",R.drawable.guanyin))

        imageList_shang.add(image("青铜双羊尊",R.drawable.yang_ding))
        imageList_shang.add(image("杜岭方鼎",R.drawable.fang_ding))

    }

}