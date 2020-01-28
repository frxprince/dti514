package com.drpaween.mjuonlineradio

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
    override fun onPause() {
        super.onPause()
        Mp.pause()
    }

    override fun onResume() {
        super.onResume()
        Mp.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    Mp= MediaPlayer()
    Mp.setDataSource(this, Uri.parse("http://112.121.150.133:8282/;stream"))
        Mp.prepare()
    if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=
            PackageManager.PERMISSION_GRANTED)
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.INTERNET),123)
    button.setOnClickListener { finish() }

    }
}
