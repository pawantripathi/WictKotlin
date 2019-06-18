package org.wictphiladelphia.wict.adaptors

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.schedule_row_item.view.*
import org.wictphiladelphia.wict.R
import org.wictphiladelphia.wict.models.Schedule


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
        holder.subTitleView.text = schedule.subTitle
        holder.speakersView.text = schedule.speakers
        holder.locationView.text = schedule.location
        holder.timeView.text = (schedule.time)
        holder.labelView.text = schedule.label


        holder.titleView.visibility = if (TextUtils.isEmpty(schedule.title)) View.GONE else View.VISIBLE
        holder.subTitleView.visibility = if (TextUtils.isEmpty(schedule.subTitle)) View.GONE else View.VISIBLE
        holder.speakersView.visibility = if (TextUtils.isEmpty(schedule.speakers)) View.GONE else View.VISIBLE
        holder.locationView.visibility = if (TextUtils.isEmpty(schedule.location)) View.GONE else View.VISIBLE
        holder.timeView.visibility = if (TextUtils.isEmpty(schedule.time )) View.GONE else View.VISIBLE
        holder.labelView.visibility = if (TextUtils.isEmpty(schedule.label )) View.GONE else View.VISIBLE

    }


}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val titleView: TextView = view.title
    val subTitleView: TextView = view.sub_title
    val speakersView: TextView = view.speakers
    val timeView : TextView = view.time
    val locationView:TextView = view.location
    val labelView: TextView = view.label

}