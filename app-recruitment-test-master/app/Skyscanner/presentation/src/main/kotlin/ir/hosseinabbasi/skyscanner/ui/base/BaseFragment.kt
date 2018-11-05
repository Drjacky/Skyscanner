package ir.hosseinabbasi.skyscanner.ui.base

import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import dagger.android.support.DaggerFragment
import ir.hosseinabbasi.skyscanner.R

/**
 * Created by Dr.jacky on 11/4/2018.
 */
abstract class BaseFragment : DaggerFragment() {

    private var mProgressDialog: ProgressDialog? = null

    protected fun showLoading() {
        hideLoading()
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(activity)
            mProgressDialog?.show()
        } else {
            mProgressDialog?.show()
        }
        if (mProgressDialog?.window != null) {
            mProgressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        mProgressDialog?.setContentView(R.layout.progress_dialog)
        mProgressDialog?.isIndeterminate = true
        mProgressDialog?.setCancelable(true)
        mProgressDialog?.setCanceledOnTouchOutside(false)
    }

    protected fun hideLoading() = mProgressDialog?.cancel()
}