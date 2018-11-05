package ir.hosseinabbasi.skyscanner.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * Run an operation just once and returns the result; without considering how many observers observe it.
 */
class OperationLiveData<T>(private val operation: OperationLiveData<T>.() -> Unit) : MutableLiveData<T>() {

    private var operated = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)

        operate()
    }

    override fun observeForever(observer: Observer<in T>) {
        super.observeForever(observer)

        operate()
    }

    private fun operate() {
        if (value != null && operated.get()) {
            return
        }

        operation()
        operated.set(true)
    }
}