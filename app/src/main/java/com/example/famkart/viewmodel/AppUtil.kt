package com.example.famkart.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.core.app.NotificationCompat.MessagingStyle.Message

object AppUtil {

    fun showToast(context: Context,message: String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }


}