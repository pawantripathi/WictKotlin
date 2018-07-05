package org.wictphiladelphia.wict.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.text.util.LinkifyCompat
import android.support.v7.widget.Toolbar
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.MenuItem
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_profile_details.*
import kotlinx.android.synthetic.main.toolbar.*
import org.wictphiladelphia.wict.R
import org.wictphiladelphia.wict.R.id.*
import org.wictphiladelphia.wict.activities.ModalActivity
import org.wictphiladelphia.wict.models.Biodata

class ProfileDetails: ModalActivity(){
    companion object {

        val EXTRA_POSITION = "wict.wictphiladelphia.PROFILE_OBJ"

        fun show(context: Context, profile : Biodata){
            val intent = Intent(context, ProfileDetails::class.java)
            intent.putExtra(EXTRA_POSITION, profile)
            context.startActivity(intent)

        }
    }


    private var profile: Biodata? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)

        setSupportActionBar(profile_details_toolbarview as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val data = intent.getSerializableExtra(EXTRA_POSITION)

        if (data is Biodata){
            profile = data as Biodata
        }


        toolbar_title.text = profile?.name
        changeStatusBarColor(ResourcesCompat.getColor(resources, R.color.lavender, null))


        profile_detail_avatar.setImageResource(profile?.imageRes!!)
        profile_designation.text = profile?.designation
        profile_name.text = profile?.name

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            profile_summary.text = Html.fromHtml(profile?.summary, Html.FROM_HTML_MODE_LEGACY)
        } else {
            profile_summary.text= Html.fromHtml(profile?.summary)

        }

        LinkifyCompat.addLinks(profile_summary, Linkify.ALL)
        profile_summary.linksClickable = true

        profile_summary.movementMethod = LinkMovementMethod.getInstance()


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            android.R.id.home->{
                onBackPressed()
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }



    fun changeStatusBarColor(color: Int){

        profile_details_toolbarview.setBackgroundColor(color)
        window.statusBarColor = color

    }

}