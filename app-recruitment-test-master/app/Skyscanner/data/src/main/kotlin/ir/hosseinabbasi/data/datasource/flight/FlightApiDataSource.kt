package ir.hosseinabbasi.data.datasource.flight

import io.reactivex.Observable
import io.reactivex.Single
import ir.hosseinabbasi.domain.entity.Entity
import retrofit2.adapter.rxjava2.Result

/**
 * Created by Dr.jacky on 11/2/2018.
 */
/**
 * Flight network data source
 */
interface FlightApiDataSource {

    /**
     * Create session
     *
     * @return a Location from its header
     */
    fun createSession(outboundDate: String, inboundDate: String, apiKey: String): Observable<Result<Any>>

    /**
     * Get all of flights from network
     *
     * @return a Single that emits flights
     */
    fun getFlights(url: String): Single<List<Entity.Flight>>
}