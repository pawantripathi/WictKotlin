package wict.wictphiladelphia.org.wict

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_about ->{
                message.setText(R.string.title_about)
                changeStatusBarColor(Color.BLUE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_schedule -> {
                message.setText(R.string.title_schedule)
                changeStatusBarColor(Color.CYAN)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_location -> {
                message.setText(R.string.title_location)
                changeStatusBarColor(Color.GREEN)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sponsors -> {
                message.setText(R.string.title_sponsor)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bios -> {
                message.setText(R.string.title_bios)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.disableShiftMode()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun changeStatusBarColor(color: Int){

        window.statusBarColor = color

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
}
