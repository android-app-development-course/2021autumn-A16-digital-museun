package com.example.digital_museun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_article.*

class article: AppCompatActivity()  {
    private val commentList=ArrayList<Comment>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_article)
//        initComment()
//        val adapter=CommentAdapter(this,R.layout.activity_comment,commentList)
//        listView.adapter=adapter
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        initComment()
        val layoutManager= LinearLayoutManager(this)
        commentRecyclerView.layoutManager=layoutManager
        val adapter=CommentAdapter(commentList)
        commentRecyclerView.adapter=adapter

    }
    private fun initComment(){
        var level:Int=1
        commentList.add(Comment(level,"你好，请问这个文物能在哪个博物馆看到呢？",R.drawable.user2,"user2"))
        level+=1
        commentList.add(Comment(level,"我也准备去现场观摩一下？",R.drawable.user1,"user1"))


    }
}