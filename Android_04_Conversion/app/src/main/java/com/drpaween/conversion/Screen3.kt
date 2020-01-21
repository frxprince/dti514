package com.drpaween.conversion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_screen3.*

class Screen3 : AppCompatActivity() {
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.rotate,R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.rotate,R.anim.fade_out)
        setContentView(R.layout.activity_screen3)
        var i= Intent()
        button3.setOnClickListener(){
            i.putExtra("data","kb")
            setResult(Activity.RESULT_OK,i)
            finish()
        }
        button4.setOnClickListener(){
            i.putExtra("data","mb")
            setResult(Activity.RESULT_OK,i)
            finish()
        }
        button5.setOnClickListener(){
            i.putExtra("data","gb")
            setResult(Activity.RESULT_OK,i)
            finish()
        }


    }
}
