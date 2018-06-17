package wict.wictphiladelphia.org.wict.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wict.wictphiladelphia.org.wict.R
import wict.wictphiladelphia.org.wict.models.Schedule
import kotlinx.android.synthetic.main.fragment_schedule.schedule_list;
import wict.wictphiladelphia.org.wict.adaptors.SchedulesAdapter


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
        schedules.add(Schedule("8:00am - 10:00am", "Registration", "and continental breakfast", "Connelly Hall"))
        schedules.add(Schedule("8:00am - 05:15pm", "Sponsor Showcase", "exhibits", "TBD"," TBD"))
        schedules.add(Schedule("8:00am - 10:00am", "Morning General Sessions"))
        schedules.add(Schedule("8:00am - 09:15am", "PHILLYBLOCO–Brazilian Music to Shake Your Body and Soul"))
        schedules.add(Schedule("09:15am", "Orientation", "and continental breakfast", "Connelly Hall","Michele Corsini and Mary Malone"))
        schedules.add(Schedule("09:25am", "Welcome to Villanova", "", "","Dr. Adele Lindenmyer, Dean, College of Liberal Arts and Sciences, Villanova University"))

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadSchedules()
        schedule_list.layoutManager = LinearLayoutManager(activity!!)
        schedule_list.adapter = SchedulesAdapter(schedules, activity!!)

    }



}