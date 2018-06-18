package wict.wictphiladelphia.org.wict.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.text.util.LinkifyCompat
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_about.*
import wict.wictphiladelphia.org.wict.R

class AboutFragment: Fragment(){

    companion object {
        fun newInstance():AboutFragment{
            return AboutFragment()
        }
    }

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_about, container, false)

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            about.text = Html.fromHtml(resources.getString(R.string.about_wict_text), Html.FROM_HTML_MODE_LEGACY)
        } else {
            about.text = Html.fromHtml(resources.getString(R.string.about_wict_text))

        }
        about.movementMethod = LinkMovementMethod.getInstance()
        LinkifyCompat.addLinks(about, Linkify.ALL)

    }

}