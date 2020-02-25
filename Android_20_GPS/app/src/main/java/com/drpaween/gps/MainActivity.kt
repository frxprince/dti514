package com.drpaween.gps

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,LocationListener,OnNmeaMessageListener{
lateinit var gps:LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),123)
 gps=getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun onPause() {
        super.onPause()
        gps.removeUpdates(this)
        gps.removeNmeaListener(this)
    }

    override fun onResume() {
        super.onResume()
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),123)
        }else {
            gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this)
            gps.addNmeaListener(this)
        }
    }

    override fun onLocationChanged(location: Location?) {
   textView.text=""" Lat:${location!!.latitude}, Long:${location.longitude}, Alt:${location.altitude}
   Clock: ${location.time} , Velocity:${location.speed}, Bearing:${location.bearing}    
       
   """.trimIndent()
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {  }

    override fun onProviderEnabled(provider: String?) {   }

    override fun onProviderDisabled(provider: String?) {
  }

    override fun onNmeaMessage(message: String?, timestamp: Long) {
        textView2.text=message+"\n"+textView2.text
    }
}
