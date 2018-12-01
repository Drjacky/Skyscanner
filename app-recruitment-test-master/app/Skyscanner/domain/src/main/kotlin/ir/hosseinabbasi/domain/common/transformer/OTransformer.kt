package ir.hosseinabbasi.domain.common.transformer

import io.reactivex.ObservableTransformer

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * A transformer to io thread for observables.
 */
abstract class OTransformer<T> : ObservableTransformer<T, T>