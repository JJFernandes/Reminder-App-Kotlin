package com.cs4080.reminder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_view.view.*
import com.cs4080.reminder.MainActivity.Companion.global_noteList

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return global_noteList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.cell_view, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.textView_descript.text = global_noteList[position].getText()
        holder.view.textView_date.text = global_noteList[position].getDate()
        holder.view.textView_time.text = global_noteList[position].getTime()
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}