package com.drpaween.filepicker

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
if (resultCode== Activity.RESULT_OK){
  var uri=data?.data as Uri
 textView.text=uri.toString()+MediaURItoPath(uri)
 //       Log.v("Hello world",MediaURItoPath(uri))
 }
    }

    fun MediaURItoPath(uri:Uri):String{
        var proj= arrayOf(MediaStore.Images.Media.DATA )
        Log.v("stringxxx",MediaStore.Images.Media.DATA)
        var cursor=contentResolver.query(uri,proj,null,null,null)

while (cursor!!.moveToNext())
{
    Log.v("cursor ",cursor.getString(0))
}

        cursor.close()
        return "hello"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),12345)

button.setOnClickListener {
    var i= Intent()
    i.setType("*/*")
    i.setAction(Intent.ACTION_GET_CONTENT)
    startActivityForResult(Intent.createChooser(i,"Please select a file"),1234)
}
    }
}
