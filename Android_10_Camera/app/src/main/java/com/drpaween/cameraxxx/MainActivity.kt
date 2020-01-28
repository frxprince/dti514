package com.drpaween.cameraxxx

import android.app.Activity
import android.content.Intent
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var image: Bitmap?=null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.v("hello world","camera returned!")
     if(resultCode== Activity.RESULT_OK){
      if (image!=null)image?.recycle()
         image=data!!.extras!!.getParcelable("data")
         var canvas=Canvas(image!!)
         var paint= Paint()
         paint.setColor(Color.MAGENTA)
         paint.textSize=8.0F
         paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OVER))
         canvas.drawBitmap(image!!,0.0f,0.0f,paint)
         canvas.drawText(Calendar.getInstance().time.toString(),1.0F,20.0F,paint)

         imageView.setImageBitmap(image)
     }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 button.setOnClickListener {
     var i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
     startActivityForResult(i,1234)
 }
    }
}
