package ir.hosseinabbasi.domain.common.transformer

import io.reactivex.FlowableTransformer

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * A transformer to io thread for flowables.
 */
abstract class FTransformer<T> : FlowableTransformer<T, T>