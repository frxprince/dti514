package com.drpaween.sensorscanner

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SensorEventListener,AdapterView.OnItemSelectedListener {
lateinit var manager:SensorManager
    lateinit var sensor:Sensor
lateinit var allsensor:MutableList<Sensor>
    override fun onPause() {
        super.onPause()
        manager.unregisterListener(this,sensor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
   allsensor=manager.getSensorList(Sensor.TYPE_ALL)
 var sensorName= mutableListOf<String>()
  for( item in allsensor){ sensorName.add(item.name)}
  var adapter=ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,sensorName)
  spinner.adapter=adapter
  spinner.onItemSelectedListener=this
  sensor=allsensor[0]
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) { }

    override fun onSensorChanged(event: SensorEvent?) {
    var msg:String=""
    for((index,item) in event!!.values.withIndex()){msg+="Parameter $index=$item\n"}
    textView.text=msg
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
     if(sensor!=null)manager.unregisterListener(this,sensor)
        sensor=allsensor[position]
    manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    textView2.text=""" Name: ${sensor.name}
        Vender: ${sensor.vendor}
        Version: ${sensor.version}
        Max: ${sensor.maximumRange}
        Resolution: ${sensor.resolution}        
    """.trimIndent()






       }
}
