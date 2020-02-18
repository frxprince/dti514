package com.drpaween.remotecontroll

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class MySMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.v("My Remote controll","Activated@!")
  var msg=Telephony.Sms.Intents.getMessagesFromIntent(intent)[0]
   var i=Intent(context,MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        when(msg.displayMessageBody){
          "DTI"-> {context.startActivity(i)
              context.startActivity(i)
          }
          "CAT"->{
              i.putExtra("cmd","cat")
              context.startActivity(i)
              context.startActivity(i)
          }
            "ALARM"->{
                i.putExtra("cmd","alarm")
                context.startActivity(i)
                context.startActivity(i)
            }
        }
    }
}
