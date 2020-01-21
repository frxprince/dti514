package com.drpaween.conversion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_screen2.*

class Screen2 : AppCompatActivity() {
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

    }

    var multiplier:Double=0.0
    var suffix:String=""
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1234)
            if (resultCode== Activity.RESULT_OK)
            {
               multiplier=when(data?.getStringExtra("data")?:"none"){
                   "kb"->{
                       suffix="kB"
                       1/1000.0}
                   "mb"->{
                       suffix="MB"
                       1/1000000.0}

                   "gb"->{
                       suffix="GB"
                        1/100000000.0}
                   else->1.0
               }

               // button2.text="$multiplier"
                // button2.text=data?.getStringExtra("data")?:"none"
            }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_screen2)

       var animate=AnimationUtils.loadAnimation(this,R.anim.blink)
        button.startAnimation(animate)

        button.setOnClickListener(){
         var i= Intent(this,Screen3::class.java)
         startActivityForResult(i,1234)
        }
        button2.setOnClickListener(){
         var i=Intent(this,Screen4::class.java)
            i.putExtra("input",editText.text.toString())
            i.putExtra("multiplier",multiplier)
            i.putExtra("suffix",suffix)
            startActivity(i)
        }
    }
}
