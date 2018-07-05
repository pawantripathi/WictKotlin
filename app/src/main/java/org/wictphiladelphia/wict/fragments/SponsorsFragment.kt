package org.wictphiladelphia.wict.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sponsors.*
import org.wictphiladelphia.wict.R
import org.wictphiladelphia.wict.models.SponsorInfo
import org.wictphiladelphia.wict.ui.ChildWrappingContainer

import java.io.IOException

class SponsorsFragment: Fragment(){

    companion object {
        fun newInstance():SponsorsFragment{
            return SponsorsFragment()
        }
    }

    var sponsors: ArrayList<SponsorInfo> = ArrayList()

    var rootView: View? = null

    var inflater: LayoutInflater? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_sponsors, container, false)
        this.inflater = inflater
        return rootView
    }



    private fun loadSponsors(){
        try{
            val data = SponsorInfo.load(activity)
            sponsors.addAll(data)
        }catch (e: IOException){
            sponsor_status.text = "Unable to load Sponsors Info."
            sponsor_status.visibility = View.VISIBLE
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadSponsors()


        for (info in sponsors){
            val sponsorCategoryView = ChildWrappingContainer(activity, info.title, info.sponsorIcons)
            if (info.category == 1){
                main_container.addView(sponsorCategoryView)
            }else{
                secondary_container.addView(sponsorCategoryView)
            }

            sponsorCategoryView.lazyLoad(activity)
        }


    }


}