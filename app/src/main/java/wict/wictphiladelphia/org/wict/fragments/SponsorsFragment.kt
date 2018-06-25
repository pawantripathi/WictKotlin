package wict.wictphiladelphia.org.wict.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_sponsors.*
import wict.wictphiladelphia.org.wict.R
import wict.wictphiladelphia.org.wict.models.SponsorInfo
import wict.wictphiladelphia.org.wict.ui.ChildWrappingContainer
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

            main_container.addView(sponsorCategoryView)

        }
    }


}