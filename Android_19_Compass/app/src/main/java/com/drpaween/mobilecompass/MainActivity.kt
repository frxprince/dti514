package com.drpaween.mobilecompass

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.PI
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener,SensorEventListener {
lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    override fun onPause() {
        super.onPause()
    manager.unregisterListener(this,sensor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar.max=360
        seekBar.progress=180
        seekBar.setOnSeekBarChangeListener(this)
        manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor=manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

    }

    override fun onResume() {
        super.onResume()
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
    imageView.rotation=progress.toFloat()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
    override fun onStopTrackingTouch(seekBar: SeekBar?) {    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent?) {
     var x=event!!.values[0]
     var y=event!!.values[1]
     var degree= (atan2(y,x) /PI)*180
        imageView.rotation=-degree.toFloat()

    }
}
