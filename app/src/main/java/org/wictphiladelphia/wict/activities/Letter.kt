package org.wictphiladelphia.wict.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.Toolbar

import android.view.MenuItem
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*
import org.wictphiladelphia.wict.R


class Letter: ModalActivity(){


    companion object {
        fun show(context: Activity){
            val intent = Intent(context, Letter::class.java)
            context.startActivity(intent)

        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)

        setSupportActionBar(toolbarView as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbar_title.text = "Letter"
        changeStatusBarColor(ResourcesCompat.getColor(resources, R.color.lavender, null))
    }


    fun changeStatusBarColor(color: Int){

        toolbarView.setBackgroundColor(color)
        window.statusBarColor = color

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


}