package com.drpaween.unitconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(){
           // Log.v("My tag","Hello world")
           // Log.v("My tag", editText.text.toString())
           // textView.text="Enter:"+editText.text.toString()
            try {
                var input: Double = editText.text.toString().toDouble()
                var ans: Double = input * 2.54
                textView.text= "%.3f".format(ans)
            }catch (e: NumberFormatException){
                textView.text= "Invalid input"
            }
        }
        button2.setOnClickListener(){
          textView.text="${editText.text.toString().toDouble()/2.54}"
        }
        button3.setOnClickListener(){ finish()}

    }
}
