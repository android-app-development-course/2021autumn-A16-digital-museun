package com.example.digital_museun

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.image


class KotlinRecycleAdapter(val imageList:List<image>) : RecyclerView.Adapter<KotlinRecycleAdapter.ViewHolder> ()
{
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image:ImageView = view.findViewById(R.id.imageView)
        val image_name:TextView = view.findViewById(R.id.textView)
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KotlinRecycleAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item1,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: KotlinRecycleAdapter.ViewHolder, position: Int) {
        val image = imageList[position]
        holder.image.setImageResource(image.imageId)
        holder.image_name.text = image.name

    }
    override fun getItemCount() = imageList.size
}