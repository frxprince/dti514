package com.drpaween.conversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_screen4.*

class Screen4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen4)
        var i=intent
        var inputx=i.getStringExtra("input")
        var multiplier=i.getDoubleExtra("multiplier",0.0)
        var suffix=i.getStringExtra("suffix")
        textView2.text="input:$inputx\n ans:%.10f $suffix".format(inputx.toDouble()*multiplier)

    }
}
