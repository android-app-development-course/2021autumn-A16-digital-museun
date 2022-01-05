package com.example.digital_museun

import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter (val itemList:List<Item>,val that:community):
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //一个卡片的内容控件
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
        val itemName: TextView = view.findViewById(R.id.itemName)
        val _abstract:TextView=view.findViewById(R.id._abstract)
        val userImage:ImageView=view.findViewById(R.id.userImage)
        val userName:TextView=view.findViewById(R.id.userName)
        val favour:ImageView=view.findViewById(R.id.favour)
        val good:ImageView=view.findViewById(R.id.good)
        val favourCount:TextView=view.findViewById(R.id.goodCount)
        val goodCount:TextView=view.findViewById(R.id.favourCount)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
        val viewHolder=ViewHolder(view)

        //点击瀑布流中每个卡片的事件
        viewHolder.itemView.setOnClickListener{
            val position=viewHolder.adapterPosition
            val item=itemList[position]
            if (position==0) {
                var intent = Intent(that.activity, article()::class.java)
                Log.d("that", that.activity.toString())
                that.activity?.startActivity(intent)
            }

        }

        viewHolder.good.setOnClickListener(){
            val position=viewHolder.adapterPosition
            val item=itemList[position]

            //点击收藏事件
            if (item.goodCount==0) {
                viewHolder.good.setImageResource(R.drawable.good_onclick)
            }
            else{
                viewHolder.good.setImageResource(R.drawable.good)
            }
            //item.goodCount+=1
            Toast.makeText(parent.context,"你已为${item.name}点赞",Toast.LENGTH_SHORT).show()

        }

        viewHolder.favour.setOnClickListener(){
            val position=viewHolder.adapterPosition
            val item=itemList[position]

            //点击收藏事件
            if (item.favourCount==0) {
                viewHolder.favour.setImageResource(R.drawable.favour_onclick)
            }
            else{
                viewHolder.favour.setImageResource(R.drawable.favour)
            }
            //item.goodCount+=1
            Toast.makeText(parent.context,"你已收藏${item.name}",Toast.LENGTH_SHORT).show()
        }


        return viewHolder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = itemList[position]
        if (item.imageId!=0) {
            holder.itemImage.setImageResource(item.imageId)
        }
//        if(item.imageBitmap!=null){
//            holder.itemImage.setImageBitmap(item.imageBitmap)
//        }
        if(item.imageByteArray!=null){
            val imageByteArray=item.imageByteArray
            holder.itemImage.setImageBitmap(BitmapFactory.decodeByteArray(imageByteArray,0,imageByteArray.size))
        }
        holder.itemName.text = item.name
        holder._abstract.text=item.abstract
        holder.userImage.setImageResource(item.userImageId)
        holder.userName.text=item.userName
//        holder.favourCount.text=item.favourCount.toString()
//        holder.goodCount.text=item.goodCount.toString()




    }

    override fun getItemCount() = itemList.size
}


