package com.cs4080.reminder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_reminder.*
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import java.text.SimpleDateFormat
import java.util.*
import com.cs4080.reminder.MainActivity.Companion.global_noteList


class NewReminderActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_reminder)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        button_date_dialog.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ _, mYear:Int, mMonth:Int, mDay:Int->
                c.set(Calendar.MONTH, mMonth)
                c.set(Calendar.DAY_OF_MONTH, mDay)
                c.set(Calendar.YEAR, mYear)
                //set to textView
                textView_select_date.text = SimpleDateFormat("MM/dd/yyyy").format(c.time)
            }, year, month, day)

            dpd.show()
        }

        button_time_dialog.setOnClickListener {
            val tpd = TimePickerDialog.OnTimeSetListener{ _, mHour:Int, mMinute:Int ->
                c.set(Calendar.HOUR_OF_DAY, mHour)
                c.set(Calendar.MINUTE, mMinute)
                //set time to textView
                textView_select_time.text = SimpleDateFormat("HH:mm").format(c.time)
            }
            TimePickerDialog(this, tpd, hour, minute, true).show()
        }

        button_create_reminder.setOnClickListener {

            val note = NotificationObject(editText_reminder.text.toString(), textView_select_date.text.toString(), textView_select_time.text.toString())

            global_noteList.add(note)

            global_noteList = insertionsort(global_noteList)


            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }

    private fun insertionsort(items: ArrayList<NotificationObject>): ArrayList<NotificationObject> {
        if (items.isEmpty() || items.size<2){
            return items
        }
        for (count in 1 until items.count()){
            // println(items)
            val item = items[count]
            var i = count
            while (i>0 && item.getTimeSum() < items[i - 1].getTimeSum()){
                items[i] = items[i - 1]
                i -= 1
            }
            items[i] = item
        }
        return items
    }


}
