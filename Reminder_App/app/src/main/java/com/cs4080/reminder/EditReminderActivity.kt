package com.cs4080.reminder

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_reminder.*
import java.text.SimpleDateFormat
import java.util.*
import com.cs4080.reminder.MainActivity.global_var.GLOBAL_REMIND_LIST

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class EditReminderActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_reminder)

        val position :Int = intent.extras.getInt("position")

        editText_reminder.setText(GLOBAL_REMIND_LIST[position].getText())
        textView_select_date.text = GLOBAL_REMIND_LIST[position].getDate()
        textView_select_time.text = GLOBAL_REMIND_LIST[position].getTime()


        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        val cDate : Date = dateFormat.parse(GLOBAL_REMIND_LIST[position].getDate())
        val d : Calendar = Calendar.getInstance()
        d.time = cDate

        val timeFormat = SimpleDateFormat("HH:mm")
        val cTime : Date = timeFormat.parse(GLOBAL_REMIND_LIST[position].getTime())
        val t : Calendar = Calendar.getInstance()
        t.time = cTime

        val c = Calendar.getInstance()

        val year = d.get(Calendar.YEAR)
        val month = d.get(Calendar.MONTH)
        val day = d.get(Calendar.DAY_OF_MONTH)

        val hour = t.get(Calendar.HOUR_OF_DAY)
        val minute = t.get(Calendar.MINUTE)


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

        button_save_changes.setOnClickListener {


            val note = ReminderObject(editText_reminder.text.toString(), textView_select_date.text.toString(), textView_select_time.text.toString())

            GLOBAL_REMIND_LIST.removeAt(position)

            GLOBAL_REMIND_LIST.add(note)

            GLOBAL_REMIND_LIST = insertionSort(MainActivity.GLOBAL_REMIND_LIST)


            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }

    private fun insertionSort(items: ArrayList<ReminderObject>): ArrayList<ReminderObject> {
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
