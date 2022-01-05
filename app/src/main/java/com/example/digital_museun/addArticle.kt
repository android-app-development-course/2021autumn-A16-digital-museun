package com.example.digital_museun

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_article.*
import java.io.ByteArrayOutputStream

class addArticle: AppCompatActivity(){
    val fromAlum=1

    //    lateinit var bitmap:Bitmap
    lateinit var imageByteArray:ByteArray
//    lateinit var title:String
//    lateinit var content:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_article)


        fromAlbumBtn.setOnClickListener(){
            val intent= Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type="image/*"
            startActivityForResult(intent,fromAlum)

        }
        handinArticle.setOnClickListener(){
            //新建文章内容
            var title=articleTitle.text.toString()
            var content=articleContent.text.toString()

            var ok=0
            if (title.isEmpty()){
                Toast.makeText(this,"你还没填写标题", Toast.LENGTH_SHORT).show()

            }else{
                ok=1
            }
            if (ok==1&&content.isEmpty()){
                Toast.makeText(this,"你还没填写内容", Toast.LENGTH_SHORT).show()

            }else{
                if(ok==1&&!content.isEmpty()) {
                    ok = 2
                }
            }
//            if (ok==2&&this::bitmap.isInitialized){
//                Toast.makeText(this,"发布成功", Toast.LENGTH_SHORT).show()
//                val intent=Intent(this,Community()::class.java)
//                intent.putExtra("title",title)
//                intent.putExtra("imageBitmap",bitmap)
//                intent.putExtra("content",content)
//                startActivity(intent)
//
//            }
            if (ok==2&&this::imageByteArray.isInitialized){
                Toast.makeText(this,"发布成功!", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,MainActivity()::class.java)
                intent.putExtra("id",1)
                intent.putExtra("title",title)
                intent.putExtra("imageByteArray",imageByteArray)
                intent.putExtra("content",content)
                startActivity(intent)

            }
            if(ok==2){
                Toast.makeText(this,"发布成功!", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,MainActivity()::class.java)
                intent.putExtra("id",1)
                intent.putExtra("title",title)
                intent.putExtra("content",content)
                startActivity(intent)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            fromAlum->{
                if(resultCode== Activity.RESULT_OK&&data!=null){
                    data.data?.let {
                            uri ->
//                            val bitmap= getBitmapFromUri(uri)!!
                        val bitmap= getBitmapFromUri(uri)!!
                        imageView.setImageBitmap(bitmap)
                        val baos = ByteArrayOutputStream()
                        bitmap.compress(Bitmap.CompressFormat.PNG,100,baos)
                        imageByteArray=baos.toByteArray()

                    }

                }
            }

        }

    }

    private fun getBitmapFromUri(uri: Uri): Bitmap? =contentResolver.openFileDescriptor(uri,"r")?.use {
        BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
    }

}