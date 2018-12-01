package ir.hosseinabbasi.skyscanner.ui

import android.os.Bundle
import ir.hosseinabbasi.skyscanner.R
import ir.hosseinabbasi.skyscanner.ui.base.BaseActivity

/**
 * Created by Dr.jacky on 10/31/2018.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavControllerId(): Int = R.id.activityMainHomeHostFragment
}
