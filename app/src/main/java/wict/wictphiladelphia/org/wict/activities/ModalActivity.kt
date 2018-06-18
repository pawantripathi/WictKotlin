package wict.wictphiladelphia.org.wict.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import wict.wictphiladelphia.org.wict.R

open class ModalActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.open_modal,R.anim.fade_out)
        super.onCreate(savedInstanceState)
    }


    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in, R.anim.close_modal)
    }
}