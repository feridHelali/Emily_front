package com.example.learn.utils

import android.icu.text.SimpleDateFormat
import java.sql.Timestamp
import java.util.*

object Time {
    fun timeStamp():String {
        val timeStamp= Timestamp(System.currentTimeMillis())
        val sdf =java.text.SimpleDateFormat("HH:mm")
        val time =sdf.format(Date(timeStamp.time))
        return time.toString()
    }
}