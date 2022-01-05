package com.example.digital_museun

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.digital_museun.addArticle
import kotlinx.android.synthetic.main.fragment_community.*
import kotlin.math.min

class community : Fragment() {
    private val itemList=ArrayList<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initItem()
        val layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=layoutManager
        val adapter=ItemAdapter(itemList,this)
        recyclerView.adapter=adapter

        addArticle.setOnClickListener(){
            val intent= Intent(this.activity,addArticle()::class.java)
            this.activity?.startActivity(intent)
        }

    }

    private fun initItem(){
        val imageByteArray= activity?.intent?.getByteArrayExtra("imageByteArray")
        val title=activity?.intent?.getStringExtra("title").toString()
        val content=activity?.intent?.getStringExtra("content").toString()
        if (title!="null"&&content!="null"){
            val dropContent = content.substring(min(8, content.length))
            val abstract = dropContent
            if(imageByteArray!=null) {
                itemList.add(
                    Item(title,0, imageByteArray, 0, 0, abstract, R.drawable.user1, "未登陆用户")
                )
            }else{
                itemList.add(
                    Item(title,0, null, 0, 0, abstract, R.drawable.user1, "未登陆用户")
                )
            }
        }


        //添加瀑布流内容
        repeat(1){
            itemList.add(
                Item("汝窑天蓝釉刻花鹅颈瓶",R.drawable.temp5,null,0,0,"此瓶敞口细颈，鼓...",R.drawable.user1,"河南博物院")
            )
            itemList.add(
                Item("成化斗彩鸡缸杯",R.drawable.chcjtb,null,0,0,"成化斗彩鸡缸杯是汉族传统陶瓷中的艺术珍..",R.drawable.user3,"台北故宫博物院")

            )
            itemList.add(
                Item("金镶红蓝宝石冠",R.drawable.jxhlbsg,null,0,0,"该金镶红蓝宝石冠高 11.5",R.drawable.user2,"云南博物馆")

            )
            itemList.add(
                Item("元青花观音像",R.drawable.yqhgyx,null,0,0,"观音端坐，双手下垂相握..",R.drawable.user3,"杭州博物馆")

            )
            itemList.add(
                Item("杜岭方鼎",R.drawable.dlfb,null,0,0,"杜岭方鼎 中国商代中期的青铜器..",R.drawable.user1,"河南博物院")

            )
            itemList.add(
                Item("“妇好”鸮尊",R.drawable.fh,null,0,0,"妇好青铜鸮（xiao，音同枭）尊..",R.drawable.user1,"河南博物院")

            )



        }
    }

}