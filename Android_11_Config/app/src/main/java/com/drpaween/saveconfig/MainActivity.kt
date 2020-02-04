package com.drpaween.saveconfig

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var config=getSharedPreferences("myconfig",Context.MODE_PRIVATE)
            config.edit {
                putString("parameter1",editText.text.toString())
                putString("parameter2",editText2.text.toString())
                putInt("parameter3",seekBar.progress)
            }
        }
        button2.setOnClickListener {
            var config=getSharedPreferences("myconfig",Context.MODE_PRIVATE)
     editText.setText(config.getString("parameter1","default1"))
     editText2.setText(config.getString("parameter2","default2"))
     seekBar.setProgress(config.getInt("parameter3",99))
        }
        button3.setOnClickListener { finish() }
    }
}
