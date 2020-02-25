package com.drpaween.mobileprotractor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.PI
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SensorEventListener {
lateinit var sensor:Sensor
    lateinit var manager:SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
  seekBar.progressDrawable=ContextCompat.getDrawable(this,R.mipmap.bg)
  seekBar.background=ContextCompat.getDrawable(this,R.mipmap.border)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    override fun onPause() {
        super.onPause()
       manager.unregisterListener(this,sensor)
    }

    override fun onResume() {
        super.onResume()
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?) {
   var x=event!!.values[0]
   var y=event!!.values[1]
var degree= (atan2(y,x) / PI)*180
        textView2.text="$degree"
   seekBar.max=360
   seekBar.progress=  (-degree+180).toInt()
 }
}
