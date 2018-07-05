package org.wictphiladelphia.wict.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_biodata.*
import org.wictphiladelphia.wict.R
import org.wictphiladelphia.wict.activities.ProfileDetails
import org.wictphiladelphia.wict.adaptors.BiosAdapter
import org.wictphiladelphia.wict.models.Biodata

import java.io.IOException

class BiosFragment: Fragment() {

    companion object {
        fun newInstance():BiosFragment{
            return BiosFragment()
        }
    }

    var bios: ArrayList<Biodata> = ArrayList()
    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_biodata, container, false)
        return rootView
    }


    private fun loadBioData(){
        try{
            val data = Biodata.load(activity)
            bios.addAll(data)
        }catch (e: IOException){
            bio_status_text.text = "Unable to load Bios."
            bio_status_text.visibility = View.VISIBLE
        }

    }

    val clickListener = fun (item: Biodata) {

        if (isAdded()){
            ProfileDetails.show(activity!!, item)
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadBioData()
        bios_list.setHasFixedSize(true)
        bios_list.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                //GridLayoutManager(activity!!, 2)
        bios_list.adapter  = BiosAdapter(bios, activity!!, clickListener)

    }

}