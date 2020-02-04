package com.drpaween.filepicker

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
 if (resultCode== Activity.RESULT_OK){
  var uri=data?.data as Uri
 textView.setText(MediaUritoPath(uri))
 }
    }

fun MediaUritoPath(uri: Uri):String{
   var proj= arrayOf(MediaStore.Images.Media.RELATIVE_PATH)
   var cursor=contentResolver.query(uri,proj,null,null,null)
   var col_index=cursor?.getColumnIndex(MediaStore.Images.Media.RELATIVE_PATH) as Int
   cursor.moveToFirst()
   var path=cursor.getString(col_index)
   cursor.close()
        return path
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
button.setOnClickListener {
    var i= Intent()
    i.setType("*/*")
    i.setAction(Intent.ACTION_GET_CONTENT)
  startActivityForResult(Intent.createChooser(i,"Pick a file"),1234)
}
    }
}
