package com.example.digital_museun

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(val data:List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val userImage:ImageView=view.findViewById(R.id.user)
        val userName:TextView=view.findViewById(R.id.userName)
        val detail:TextView=view.findViewById(R.id.comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.activity_comment,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment=data[position]
        holder.userName.text=comment.userName
        holder.userImage.setImageResource(comment.userImageId)
        holder.detail.text=comment.detail
    }

    override fun getItemCount()=data.size


}
