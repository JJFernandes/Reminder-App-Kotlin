package com.cs4080.reminder

import java.text.SimpleDateFormat
import java.util.*


class ReminderObject(s: String, d: String, t: String) {
    private var text : String = s
    private var date : String = d
    private var time : String = t
    private var timeSum : Double = convertToTime()

    fun getText() : String {
        return text
    }

    /*fun setText(s:String) {
        text = s
    }*/

    fun getDate() : String {
        return date
    }

    /*fun setDate(s:String) {
        date = s
    }*/

    fun getTime() : String {
        return time
    }

    /*fun setTime(s:String) {
        time = s
    }*/

    fun getTimeSum() : Double {
        return timeSum
    }

    private fun convertToTime(): Double {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        val cDate : Date = dateFormat.parse(date)
        val d : Calendar = Calendar.getInstance()
        d.time = cDate

        val cMonth = d.get(Calendar.MONTH)
        val cDay = d.get(Calendar.DAY_OF_MONTH)
        val cYear = d.get(Calendar.YEAR)

        val timeFormat = SimpleDateFormat("HH:mm")
        val cTime : Date = timeFormat.parse(time)
        val t : Calendar = Calendar.getInstance()
        t.time = cTime

        val cHour = t.get(Calendar.HOUR_OF_DAY).toDouble()
        val cMin = t.get(Calendar.MINUTE).toDouble()

        val ddyyyyHHmm:Double = cDay + (cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400)

        val arrMM:Array<Int> = arrayOf(0, 31, 59, 90, 120, 151, 180, 212, 243, 273, 304, 334)

        return arrMM[cMonth]+ddyyyyHHmm
    }
}



