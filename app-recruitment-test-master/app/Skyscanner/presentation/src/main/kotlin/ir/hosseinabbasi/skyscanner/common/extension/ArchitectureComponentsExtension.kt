package ir.hosseinabbasi.skyscanner.common.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations

/**
 * Created by Dr.jacky on 10/31/2018.
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun <X, Y> LiveData<X>.switchMap(
    func: (X?) -> LiveData<Y>
): LiveData<Y> = Transformations.switchMap(this, func)