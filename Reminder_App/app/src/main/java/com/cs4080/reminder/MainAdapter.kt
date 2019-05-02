package com.cs4080.reminder

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_view.view.*
import com.cs4080.reminder.MainActivity.global_var.GLOBAL_REMIND_LIST

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return GLOBAL_REMIND_LIST.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.cell_view, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.textView_descript.text = GLOBAL_REMIND_LIST[position].getText()
        holder.view.textView_date.text = GLOBAL_REMIND_LIST[position].getDate()
        holder.view.textView_time.text = GLOBAL_REMIND_LIST[position].getTime()
        holder.view.button_delete_reminder.setOnClickListener {
            deleteItem(position)
        }
        holder.view.button_edit_reminder.setOnClickListener {
            editItem(holder, position)
        }
    }

    private fun editItem(holder: CustomViewHolder, position: Int) {
        val context: Context = holder.view.context
        val intent = Intent(context, EditReminderActivity::class.java)
        intent.putExtra("position", position)
        context.startActivity(intent)
    }

    private fun deleteItem(position: Int) {
        GLOBAL_REMIND_LIST.removeAt(position)
        notifyItemRemoved(position)
    }


}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}