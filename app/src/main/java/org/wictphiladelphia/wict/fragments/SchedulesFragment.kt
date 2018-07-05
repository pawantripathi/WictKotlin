package org.wictphiladelphia.wict.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.wictphiladelphia.wict.R
import org.wictphiladelphia.wict.adaptors.SchedulesAdapter
import org.wictphiladelphia.wict.models.Schedule

import java.io.IOException


class SchedulesFragment: Fragment(){

    companion object {
        fun newInstance(): SchedulesFragment{
            return SchedulesFragment()
        }
    }

    var schedules: ArrayList<Schedule> = ArrayList()
    var rootView : View? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_schedule, container, false)
        return rootView
    }



    private fun loadSchedules(){
        try{
            val data = Schedule.load(activity)
            schedules.addAll(data)
        }catch (e: IOException){
            status_text.text = "Unable to load schedules."
            status_text.visibility = View.VISIBLE
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadSchedules()
        schedule_list.layoutManager = LinearLayoutManager(activity!!)
        schedule_list.adapter = SchedulesAdapter(schedules, activity!!)

    }



}