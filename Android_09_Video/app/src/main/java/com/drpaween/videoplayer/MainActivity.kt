package com.drpaween.videoplayer

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
videoView.setVideoURI(Uri.parse("android.resource://${packageName}/"+
R.raw.video2))
        }
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=
        PackageManager.PERMISSION_GRANTED)
  ActivityCompat.requestPermissions(this,
      arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),123)

 button2.setOnClickListener {
 //videoView.setVideoURI(Uri.parse("/sdcard/Loituma.3gp"))
     videoView.setVideoURI(Uri.parse(
         "${Environment.getExternalStorageDirectory().path}/Loituma.3gp"))
 }
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=
            PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.INTERNET),123)
 button3.setOnClickListener {
  videoView.setVideoURI(Uri.parse("http://www.drpaween.com/ohm/cs436/mv.mp4"))
 }
 imageButton.setOnClickListener { videoView.start() }
 imageButton2.setOnClickListener { videoView.pause() }
 imageButton3.setOnClickListener { videoView.stopPlayback() }
  videoView.setMediaController(MediaController(this))
    }
}
