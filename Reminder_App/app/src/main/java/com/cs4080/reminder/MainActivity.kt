package com.cs4080.reminder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration
import android.content.Intent
import kotlinx.android.synthetic.main.cell_view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    companion object global_var{
        var GLOBAL_REMIND_LIST = ArrayList<ReminderObject>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = MainAdapter()

        recyclerView_main.addItemDecoration(
            DividerItemDecoration(
                recyclerView_main.context,
                DividerItemDecoration.VERTICAL
            )
        )

        button_new_reminder.setOnClickListener {

            val intent = Intent(this, NewReminderActivity::class.java)
            // start your next activity
            startActivity(intent)


        }
    }


}
