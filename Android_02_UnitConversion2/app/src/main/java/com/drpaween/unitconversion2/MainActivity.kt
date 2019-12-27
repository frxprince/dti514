package com.drpaween.unitconversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(){
    var ans=if (radioButton.isChecked) editText.text.toString().toDouble() *2.54 else
         editText.text.toString().toDouble() /2.54
    var suffix=if (radioButton.isChecked) resources.getString(R.string.cm) else
        resources.getString(R.string.inch)
     textView.text="$ans $suffix"
        }
        button2.setOnClickListener(){finish()}
    }
}
