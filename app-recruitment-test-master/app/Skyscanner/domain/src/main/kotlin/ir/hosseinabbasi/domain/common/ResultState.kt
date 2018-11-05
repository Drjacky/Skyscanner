package ir.hosseinabbasi.domain.common

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * A wrapper for database and network states.
 */
sealed class ResultState<T> {

    /**
     * A state of [data] which shows that we know there is still an update to come.
     */
    data class Loading<T>(val data: T) : ResultState<T>()

    /**
     * A state that shows the [data] is the last known update.
     */
    data class Success<T>(val data: T) : ResultState<T>()

    /**
     * A state to show a [throwable] is thrown beside the [lastData] which is cached.
     */
    data class Error<T>(val throwable: Throwable, val lastData: T?) : ResultState<T>()
}