package wict.wictphiladelphia.org.wict.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import wict.wictphiladelphia.org.wict.R

class LocationFragment: Fragment(){

    companion object {
        fun newInstance():LocationFragment{
            return LocationFragment()
        }
    }

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_locate, container, false)
        return rootView
    }



}