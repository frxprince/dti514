package com.drpaween.textfile

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 button.setOnClickListener {
  var file=assets.open("document1/pangram.txt")
  var lines=file.bufferedReader(Charsets.UTF_8).readLines()
     var msg=""
     for (line in lines){msg+=line+"\n"}
  editText2.setText(msg)
 }

 button2.setOnClickListener {
     var file=resources.openRawResource(R.raw.genesis01)
     var lines=file.bufferedReader(Charsets.UTF_8).readLines()
     var msg=""
     for (line in lines){msg+=line+"\n"}
     editText2.setText(msg)
 }
 if ((ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
 !=PackageManager.PERMISSION_GRANTED ) ||
     (ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
             !=PackageManager.PERMISSION_GRANTED))
 ActivityCompat.requestPermissions(this, arrayOf(
     Manifest.permission.READ_EXTERNAL_STORAGE,
     Manifest.permission.WRITE_EXTERNAL_STORAGE),124)
button3.setOnClickListener {
    var file=File(Environment.getExternalStorageDirectory().path+"/"+
            editText.text.toString())
    var outputfile=FileOutputStream(file)
    outputfile.write(editText2.text.toString().toByteArray())
    outputfile.flush()
    outputfile.close()
}
button4.setOnClickListener {
    var file=File(Environment.getExternalStorageDirectory().path+"/"+
            editText.text.toString())
    var lines=file.bufferedReader(Charsets.UTF_8).readLines()
    var msg=""
    for (line in lines){msg+=line+"\n"}
    editText2.setText(msg)
}

    }
}
