package com.drpaween.remotecontroll

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    when(intent?.getStringExtra("cmd")?:"no"){
      "cat"->{
          mp3= MediaPlayer.create(this,R.raw.cat)
          mp3.start()
      }
      "alarm"->{
          mp3= MediaPlayer.create(this,R.raw.alarm)
          mp3.start()
      }
    }
    }
    lateinit var mp3:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { finish() }
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!=
        PackageManager.PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS),124)

    }
}
