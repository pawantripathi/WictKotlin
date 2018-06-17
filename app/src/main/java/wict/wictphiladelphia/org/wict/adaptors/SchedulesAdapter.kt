package wict.wictphiladelphia.org.wict.adaptors

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.schedule_row_item.view.*
import wict.wictphiladelphia.org.wict.R

import wict.wictphiladelphia.org.wict.models.Schedule

class SchedulesAdapter(private val scheduleList: ArrayList<Schedule>,
                       private val context: Context): RecyclerView.Adapter<ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.schedule_row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val schedule = scheduleList.get(position)
        holder.titleView.text = schedule.title

    }




}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val titleView: TextView = view.title
}