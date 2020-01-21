package com.drpaween.audioplayer

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var Mp:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   button.setOnClickListener {
       var mpFile=assets.openFd("mymp3/tada.mp3")
       Mp= MediaPlayer()
       Mp.setDataSource(mpFile.fileDescriptor,mpFile.startOffset,mpFile.length)
       Mp.prepare()
   }
   button5.setOnClickListener { Mp.start() }
   button6.setOnClickListener { Mp.pause() }
   button7.setOnClickListener { Mp.stop() }
        button2.setOnClickListener {
            Mp= MediaPlayer.create(this,R.raw.greeting)
        }
 if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=
         PackageManager.PERMISSION_GRANTED)
 {
     ActivityCompat.requestPermissions(this,
         arrayOf(Manifest.permission.INTERNET),123)
 }
  button3.setOnClickListener {
      Mp= MediaPlayer()
      Mp.setDataSource(this, Uri.parse("http://www.drpaween.com/ohm/mp3test.mp3"))
      Mp.prepare()
  }


    }
}
