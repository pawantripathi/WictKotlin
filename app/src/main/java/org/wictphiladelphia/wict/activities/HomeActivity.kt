package org.wictphiladelphia.wict.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.WindowManager

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*
import org.wictphiladelphia.wict.R
import org.wictphiladelphia.wict.fragments.*


class HomeActivity : AppCompatActivity() {



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var childFragment:Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)

        when (item.itemId) {
            R.id.navigation_about ->{
                if (childFragment !is AboutFragment){
                    childFragment = AboutFragment.newInstance()
                }

                loadFragment(childFragment, "about", R.id.fragment_container)
                toolbar_title.text = resources.getString(R.string.fragment_title_about)

                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_schedule -> {
                if (childFragment !is SchedulesFragment){
                    childFragment = SchedulesFragment.newInstance()
                }

                loadFragment(childFragment, "schedule", R.id.fragment_container)
                toolbar_title.text = resources.getString(R.string.title_schedule)

                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_location -> {
                if (childFragment !is LocationFragment){
                    childFragment = LocationFragment.newInstance()
                }
                loadFragment(childFragment, "location", R.id.fragment_container)
                toolbar_title.text = resources.getString(R.string.title_location)

                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_sponsors -> {
                if (childFragment !is SponsorsFragment){
                    childFragment = SponsorsFragment.newInstance()
                }
                loadFragment(childFragment, "sponsor", R.id.fragment_container)
                toolbar_title.text = resources.getString(R.string.title_sponsor)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bios -> {
                if (childFragment !is BiosFragment){
                    childFragment = BiosFragment.newInstance()
                }

                toolbar_title.text = resources.getString(R.string.title_bios)
                loadFragment(childFragment, "bio", R.id.fragment_container)
                return@OnNavigationItemSelectedListener true

            }
        }


        false
    }


    private fun loadFragment(child: Fragment, tag: String, id : Int){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(id, child)
        transaction.addToBackStack(tag)
        transaction.commit()

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_home)
        navigation.disableShiftMode()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_schedule

        setSupportActionBar(toolbarView as Toolbar?)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        am_register.setOnClickListener{
            launchRegistration(resources.getString(R.string.registration_url))
        }

    }

    fun changeStatusBarColor(color: Int){

        toolbarView.setBackgroundColor(color)
        window.statusBarColor = color

    }


    fun launchMap(view: View){

        val mapUri = Uri.parse(String.format("geo:0,0?q=%s", resources.getString(R.string.location_lookup)))
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.`package` ="com.google.android.apps.maps"

        startActivity(mapIntent)

    }

    fun launchRegistration(url: String){
        val registerURI = Uri.parse(url)
        val openUrl = Intent(Intent.ACTION_VIEW, registerURI)
        startActivity(openUrl)
    }

    fun showWelcome(view: View){
        Welcome.show(this)
    }

    fun showThanks(view: View){
        Thanks.show(this)
    }

    @SuppressLint("RestrictedApi")
    fun BottomNavigationView.disableShiftMode() {
        val tag = "disableShift"
        val menuView = getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView::class.java.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                // set once again checked value, so view will be updated
                item.setChecked(item.itemData.isChecked)
                
            }
        } catch (e: NoSuchFieldException) {
            Log.e(tag, "Unable to get shift mode field", e)
        } catch (e: IllegalStateException) {
            Log.e(tag, "Unable to change value of shift mode", e)
        }
    }


    override fun onBackPressed() {
        finish()
    }
}
