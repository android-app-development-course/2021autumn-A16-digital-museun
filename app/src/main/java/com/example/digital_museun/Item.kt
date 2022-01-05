package com.example.digital_museun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class Item(val name:String,val imageId:Int,val imageByteArray:ByteArray?,val goodCount:Int=0,val favourCount: Int=0
           ,val abstract:String="",val userImageId:Int=0,val userName:String=""
){

}

//userId->userImageId