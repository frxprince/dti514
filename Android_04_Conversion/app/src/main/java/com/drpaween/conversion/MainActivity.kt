package com.drpaween.conversion


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener(){
            var i= Intent(this,Screen2::class.java)
            startActivity(i)
        }
    }
}
