package ir.hosseinabbasi.domain.repository.flight

import io.reactivex.Flowable
import io.reactivex.Observable
import ir.hosseinabbasi.domain.common.ResultState
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.repository.BaseRepository
import retrofit2.adapter.rxjava2.Result

/**
 * Created by Dr.jacky on 10/31/2018.
 */
/**
 * Flight repository
 */
interface FlightRepository : BaseRepository {

    /**
     * Create session
     *
     * @return a Location in tis header
     */
    fun createSession(outboundDate: String, inboundDate: String, apiKey: String): Observable<Result<Any>>

    /**
     * Get all flights from local database
     *
     * @return a Flowable that emits flights
     */
    fun getFlights(url: String): Flowable<ResultState<List<Entity.Flight>>>
}