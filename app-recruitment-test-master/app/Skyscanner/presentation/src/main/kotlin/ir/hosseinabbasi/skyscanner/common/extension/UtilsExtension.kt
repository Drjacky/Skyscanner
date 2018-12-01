package ir.hosseinabbasi.skyscanner.common.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ir.hosseinabbasi.skyscanner.R

/**
 * Created by Dr.jacky on 11/7/2018.
 */
@BindingAdapter("bind:imageUrl")
fun ImageView.loadUrl(url: String?) {
    Picasso.get().load(url).placeholder(R.mipmap.ic_launcher_round).into(this)
}