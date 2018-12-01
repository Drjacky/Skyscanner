package ir.hosseinabbasi.skyscanner.common.transformer

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.schedulers.Schedulers
import ir.hosseinabbasi.domain.common.transformer.OTransformer

/**
 * Created by Dr.jacky on 10/31/2018.
 */
class AsyncOTransformer<T> : OTransformer<T>() {

    override fun apply(upstream: Observable<T>): ObservableSource<T> =
        upstream.subscribeOn(Schedulers.io())
}