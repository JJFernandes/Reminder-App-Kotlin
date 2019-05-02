package com.cs4080.reminder

import java.text.SimpleDateFormat
import java.util.*


class NotificationObject(s: String, d: String, t: String) {
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
        println("month: $cMonth")
        val cDay = d.get(Calendar.DAY_OF_MONTH)
        println("day: $cDay")
        val cYear = d.get(Calendar.YEAR)
        println("year: $cYear")

        val timeFormat = SimpleDateFormat("HH:mm")
        val cTime : Date = timeFormat.parse(time)
        val t : Calendar = Calendar.getInstance()
        t.time = cTime

        val cHour = t.get(Calendar.HOUR_OF_DAY).toDouble()
        println("hour: $cHour")
        val cMin = t.get(Calendar.MINUTE).toDouble()
        println("min: $cMin")

        var timeSumCalc:Double = 0.0

        when(cMonth) {
            0 -> timeSumCalc+=(0 + cDay + (cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            1 -> timeSumCalc+=(31 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            2 -> timeSumCalc+=(59 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            3 -> timeSumCalc+=(90 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            4 -> timeSumCalc+=(120 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            5 -> timeSumCalc+=(151 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            6 -> timeSumCalc+=(180 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            7 -> timeSumCalc+=(212 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            8 -> timeSumCalc+=(243 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            9 -> timeSumCalc+=(273 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            10 -> timeSumCalc+=(304 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
            11 -> timeSumCalc+=(334 + cDay+(cYear*365) + ( ((cHour*3600) + (cMin*60)) / 86400))
        }

        println("timeSum: $timeSumCalc")

        return timeSumCalc
    }
}



